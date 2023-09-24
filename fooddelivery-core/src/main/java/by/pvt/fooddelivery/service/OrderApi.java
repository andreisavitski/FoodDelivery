package by.pvt.fooddelivery.service;

import by.pvt.fooddelivery.domain.Order;

import java.util.List;

public interface OrderApi {
    void addOrder(Order order);

    Order getOrderById(Long id);

    List<Order> getAllOrders();

    void deleteOrderById(Long id);
}
