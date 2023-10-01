package by.pvt.fooddelivery.service;

import by.pvt.fooddelivery.domain.Order;

import java.util.List;

public interface OrderApi {
    void addOrder(Order order);

    Order getOrderById(Long orderId);

    List<Order> getAllOrders();

    void deleteOrderById(Long orderId);

    void updateOrder(Order order);
}
