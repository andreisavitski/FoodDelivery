package by.pvt.fooddelivery.service.impl;

import by.pvt.fooddelivery.dto.OrderDTO;
import by.pvt.fooddelivery.entity.Client;
import by.pvt.fooddelivery.entity.Courier;
import by.pvt.fooddelivery.entity.Order;
import by.pvt.fooddelivery.entity.Product;
import by.pvt.fooddelivery.exception.ApplicationException;
import by.pvt.fooddelivery.mapper.OrderMapper;
import by.pvt.fooddelivery.mapper.OrderMessageMapper;
import by.pvt.fooddelivery.repository.ClientRepository;
import by.pvt.fooddelivery.repository.CourierRepository;
import by.pvt.fooddelivery.repository.OrderRepository;
import by.pvt.fooddelivery.repository.product.interfaces.ProductRepository;
import by.pvt.fooddelivery.service.OrderService;
import by.pvt.fooddelivery.service.rabbitmq.RabbitMQProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static by.pvt.fooddelivery.constant.AppConstants.*;
import static by.pvt.fooddelivery.enums.CourierStatus.BUSY;
import static by.pvt.fooddelivery.enums.CourierStatus.FREE;
import static by.pvt.fooddelivery.enums.OrderStatus.*;
import static by.pvt.fooddelivery.exception.ApplicationError.*;
import static java.math.BigDecimal.ZERO;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final RabbitMQProducer producerService;

    private final OrderRepository orderRepository;

    private final ProductRepository productRepository;

    private final ClientRepository clientRepository;

    private final CourierRepository courierRepository;

    private final OrderMapper orderMapper;

    private final OrderMessageMapper orderMessageMapper;

    @Override
    @Transactional
    public OrderDTO addOrder(String clientOrder) {
        Order order = new Order();
        order.setClient(clientRepository.findByLogin(clientOrder).orElseThrow(
                () -> new ApplicationException(CLIENT_NOT_FOUND)
        ));
        order.setOrdered(LocalDateTime.now());
        order.setOrderStatus(NOT_FORMED);
        order.setCourier(courierRepository.findById(NAMELESS_COURIER).orElseThrow(
                () -> new ApplicationException(COURIER_NOT_FOUND)
        ));
        return orderMapper.toDTO(orderRepository.save(costChecking(order.getProducts(), order)));
    }

    @Override
    @Transactional
    public void deleteOrderById(Long orderId) {
        orderRepository.delete(orderMapper.toOrder(findOrderById(orderId)));
    }

    @Override
    public OrderDTO findOrderById(Long orderId) {
        return orderMapper.toDTO(orderRepository.findById(orderId).orElseThrow(
                () -> new ApplicationException(ORDER_NOT_FOUND)
        ));
    }

    @Override
    public List<OrderDTO> findAllOrders() {
        return orderRepository.findAll().stream()
                .map(orderMapper::toDTO)
                .toList();
    }

    @Override
    public List<OrderDTO> findOrdersByClientId(Long id) {
        return orderRepository.findByClientId(id).stream()
                .map(orderMapper::toDTO)
                .toList();
    }

    @Override
    @Transactional
    public OrderDTO updateOrder(OrderDTO orderDTO) {
        findOrderById(orderDTO.getId());
        Client client = clientRepository.findByLogin(orderDTO.getClientLogin()).orElseThrow(
                () -> new ApplicationException(CLIENT_NOT_FOUND)
        );
        Order order = orderMapper.toOrder(orderDTO);
        order.setClient(client);
        return orderMapper.toDTO(orderRepository.save(order));
    }

    @Override
    @Transactional
    public void updateProductOrder(Long orderId, Long productId, String condition) {
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new ApplicationException(ORDER_NOT_FOUND));
        List<Product> orderProducts = order.getProducts();
        Product product = productRepository.findById(productId).orElseThrow(
                () -> new ApplicationException(PRODUCT_NOT_FOUND)
        );
        updateProductOrder(product, orderProducts, condition);
        order.setProducts(orderProducts);
        orderRepository.save(costChecking(orderProducts, order));
    }

    @Override
    public OrderDTO checkout(Long orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new ApplicationException(ORDER_NOT_FOUND));
        order.setOrderStatus(WAITING_FOR_COURIER);
        order.setOrdered(LocalDateTime.now());
        return orderMapper.toDTO(orderRepository.save(order));
    }

    @Override
    public List<OrderDTO> findOrdersForDelivery() {
        return orderRepository.findByOrderStatus(WAITING_FOR_COURIER).stream()
                .map(orderMapper::toDTO)
                .toList();
    }

    @Override
    public OrderDTO changeOfOrderDeliveryStatus(Long orderId, Long courierId, String condition) {
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new ApplicationException(ORDER_NOT_FOUND));
        Courier courier = courierRepository.findById(courierId).orElseThrow(
                () -> new ApplicationException(COURIER_NOT_FOUND)
        );
        switch (condition) {
            case SELECT_ORDER_FOR_DELIVERY -> {
                order.setOrderStatus(ON_THE_WAY);
                order.setCourier(courier);
                courier.setStatus(BUSY);

            }
            case REFUSAL_TO_DELIVERY_ORDER -> {
                order.setOrderStatus(WAITING_FOR_COURIER);
                order.setCourier(courierRepository.findById(NAMELESS_COURIER).orElseThrow(
                        () -> new ApplicationException(COURIER_NOT_FOUND)
                ));
                courier.setStatus(FREE);
            }
            case COMPLETE_THE_ORDER_FOR_DELIVERY -> {
                order.setOrdered(LocalDateTime.now());
                order.setOrderStatus(DONE);
                courier.setStatus(FREE);
                producerService.sendJsonMessage(orderMessageMapper.toDTO(order));
            }
        }
        return orderMapper.toDTO(orderRepository.save(order));
    }


    private BigDecimal calculationTotalCost(List<Product> products) {
        BigDecimal totalCost = ZERO;
        if (products == null) {
            return ZERO;
        }
        for (Product entry : products) {
            totalCost = totalCost.add(entry.getPrice().multiply((entry.getPrice())));
        }
        return totalCost;
    }

    private void updateProductOrder(Product product, List<Product> orderProducts,
                                    String condition) {
        switch (condition) {
            case DELETE_PRODUCT_ORDER -> {
                if (!orderProducts.contains(product)) {
                    throw new ApplicationException(PRODUCT_NOT_FOUND);
                }
                orderProducts.remove(product);
            }
            case ADD_PRODUCT_ORDER -> {
                if (!restaurantChecking(product, orderProducts)) {
                    throw new ApplicationException(ERROR_ADDING_A_PRODUCT);
                }
                orderProducts.add(product);
            }
        }
    }

    private boolean restaurantChecking(Product product, List<Product> orderProducts) {
        if (orderProducts.isEmpty()) {
            return true;
        }
        List<Product> products = orderProducts.stream().toList();
        return products.get(0).getRestaurant().equals(product.getRestaurant());
    }

    private Order costChecking(List<Product> orderProducts, Order order) {
        BigDecimal totalCost = calculationTotalCost(orderProducts);
        if (totalCost.compareTo(FREE_DELIVERY_CONDITION) < 0 &&
                totalCost.compareTo(SERVICE_FEE.add(COST_OF_DELIVERY)) != 0) {
            order.setTotalCost(totalCost);
            order.setCostOfDelivery(COST_OF_DELIVERY);
            order.setServiceFee(SERVICE_FEE);
        } else {
            order.setTotalCost(FREE_DELIVERY);
            order.setCostOfDelivery(FREE_DELIVERY);
            order.setServiceFee(FREE_DELIVERY);
        }
        return order;
    }
}
