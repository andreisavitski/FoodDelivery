package by.pvt.fooddelivery.service.impl;

import by.pvt.fooddelivery.domain.Order;
import by.pvt.fooddelivery.domain.Product;
import by.pvt.fooddelivery.dto.OrderDTO;
import by.pvt.fooddelivery.enums.OrderStatus;
import by.pvt.fooddelivery.exception.ApplicationException;
import by.pvt.fooddelivery.mapper.OrderMapper;
import by.pvt.fooddelivery.repository.ClientRepository;
import by.pvt.fooddelivery.repository.OrderRepository;
import by.pvt.fooddelivery.repository.ProductRepository;
import by.pvt.fooddelivery.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static by.pvt.fooddelivery.constant.Constant.*;
import static by.pvt.fooddelivery.enums.OrderStatus.NOT_FORMED;
import static by.pvt.fooddelivery.exception.ApplicationError.*;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final ClientRepository clientRepository;
    private final OrderMapper orderMapper;

    @Override
    @Transactional
    public OrderDTO addOrder(OrderDTO orderDTO) {
        Order order = orderMapper.toOrder(orderDTO);
        order.setClient(clientRepository.findByLogin(orderDTO.getClientLogin()).orElseThrow(() -> new ApplicationException(CLIENT_NOT_FOUND)));
        order.setProducts(new ArrayList<>());
        order.setOrdered(LocalDateTime.now());
        order.setOrderStatus(NOT_FORMED);
        return orderMapper.toDTO(orderRepository.save(costCheck(order.getProducts(), order)));
    }

    @Override
    @Transactional
    public void deleteOrderById(Long orderId) {
        orderRepository.delete(orderMapper.toOrder(findOrderById(orderId)));
    }

    @Override
    public OrderDTO findOrderById(Long orderId) {
        return orderMapper.toDTO(orderRepository.findById(orderId).orElseThrow(() -> new ApplicationException(ORDER_NOT_FOUND)));
    }

    @Override
    public List<OrderDTO> findAllOrders() {
        List<OrderDTO> orders = orderRepository.findAll().stream().map(orderMapper::toDTO).toList();
        if (orders.isEmpty()) {
            throw new ApplicationException(ORDER_NOT_FOUND);
        }
        return orders;
    }

    @Override
    @Transactional
    public OrderDTO updateOrder(OrderDTO orderDTO) {
        return orderMapper.toDTO(orderRepository.save(orderMapper.toOrder(orderDTO)));
    }

    @Override
    @Transactional
    public void updateProductOrder(Long quantity, Long orderId, Long productId, String condition) {
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new ApplicationException(ORDER_NOT_FOUND));
        List<Product> orderProducts = order.getProducts();
        if (!restaurantCheck(productId, orderProducts)) {
            throw new ApplicationException(ERROR_ADDING_A_PRODUCT);
        }
        updateProductOrder(quantity, productId, orderProducts, condition);
        order.setProducts(orderProducts);
        orderRepository.save(costCheck(orderProducts, order));
    }

    @Override
    public OrderDTO checkout(Long orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new ApplicationException(ORDER_NOT_FOUND));
        order.setOrderStatus(OrderStatus.WAITING_FOR_COURIER);
        order.setOrdered(LocalDateTime.now());
        return orderMapper.toDTO(order);
    }

    private BigDecimal calculationTotalCost(List<Product> products) {
        return products.stream().map(Product::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add).add(SERVICE_FEE).add(COST_OF_DELIVERY);
    }

    private void updateProductOrder(Long quantity, Long productId, List<Product> orderProducts, String condition) {
        while (quantity > 0) {
            switch (condition) {
                case DELETE_PRODUCT_ORDER ->
                        orderProducts.remove(productRepository.findById(productId).orElseThrow(() -> new ApplicationException(PRODUCT_NOT_FOUND)));
                case ADD_PRODUCT_ORDER ->
                        orderProducts.add(productRepository.findById(productId).orElseThrow(() -> new ApplicationException(PRODUCT_NOT_FOUND)));
            }
            quantity--;
        }
    }

    private boolean restaurantCheck(Long productId, List<Product> orderProducts) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new ApplicationException(PRODUCT_NOT_FOUND));
        if (orderProducts.isEmpty()) {
            return true;
        }
        return product.getRestaurant().getName().equals(orderProducts.get(0).getRestaurant().getName());
    }

    private Order costCheck(List<Product> orderProducts, Order order) {
        BigDecimal totalCost = calculationTotalCost(orderProducts);
        if (totalCost.compareTo(FREE_DELIVERY_CONDITION) < 0 && totalCost.compareTo(SERVICE_FEE.add(COST_OF_DELIVERY)) != 0) {
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
