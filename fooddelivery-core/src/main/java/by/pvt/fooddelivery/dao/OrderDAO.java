package by.pvt.fooddelivery.dao;

import by.pvt.fooddelivery.domain.Order;

import java.util.List;

public interface OrderDAO {
    void addOrder(Order order);

    Order getOrderById(Long id);

    List<Order> getAllOrders();

    void deleteOrderById(Long id);
}
