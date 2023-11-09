package by.pvt.fooddelivery.service.impl;

import by.pvt.fooddelivery.domain.Order;
import by.pvt.fooddelivery.domain.Product;
import by.pvt.fooddelivery.dto.OrderDTO;
import by.pvt.fooddelivery.exception.ApplicationException;
import by.pvt.fooddelivery.mapper.OrderMapper;
import by.pvt.fooddelivery.repository.OrderRepository;
import by.pvt.fooddelivery.repository.ProductRepository;
import by.pvt.fooddelivery.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

import static by.pvt.fooddelivery.constant.Constant.*;
import static by.pvt.fooddelivery.exception.ApplicationError.ORDER_NOT_FOUND;
import static by.pvt.fooddelivery.exception.ApplicationError.PRODUCT_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final OrderMapper orderMapper;

    @Override
    @Transactional
    public OrderDTO addOrder(OrderDTO orderDTO) {
//        return orderMapper.toDTO(orderRepository.save(orderMapper.toOrder(orderDTO)));
        Order order = orderMapper.toOrder(orderDTO);
        order.setCostOfDelivery(COST_OF_DELIVERY);
        order.setServiceFee(SERVICE_FEE);
        order.setTotalCost(COST_OF_DELIVERY.add(SERVICE_FEE));
        return orderMapper.toDTO(orderRepository.save(order));
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
        updateProductOrder(quantity, productId, orderProducts, condition);
        order.setProducts(orderProducts);
        BigDecimal totalCost = calculationTotalCost(orderProducts);
        if (totalCost.compareTo(FREE_DELIVERY_CONDITION) < 0) {
            order.setTotalCost(totalCost);
        } else {
            order.setTotalCost(FREE_DELIVERY);
        }
        orderRepository.save(order);
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
}
