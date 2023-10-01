package by.pvt.fooddelivery.service.impl;

import by.pvt.fooddelivery.domain.Order;
import by.pvt.fooddelivery.repository.OrderRepository;
import by.pvt.fooddelivery.service.OrderApi;

import java.util.List;

public class OrderService implements OrderApi {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void addOrder(Order order) {
        orderRepository.addOrder(order);
    }

    @Override
    public Order getOrderById(Long orderId) {
        return orderRepository.getOrderById(orderId).orElseThrow(
                () -> new RuntimeException("Order does not exist"));
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.getAllOrders();
    }

    @Override
    public void deleteOrderById(Long orderId) {
        orderRepository.deleteOrderById(orderId);
    }

    @Override
    public void updateOrder(Order order) {
        orderRepository.updateOrder(order);
    }
}
