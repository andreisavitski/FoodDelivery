package by.pvt.fooddelivery.service.impl;

import by.pvt.fooddelivery.dao.OrderDAO;
import by.pvt.fooddelivery.domain.Order;
import by.pvt.fooddelivery.service.OrderApi;

import java.util.List;

public class OrderService implements OrderApi {
    private final OrderDAO orderDAO;

    public OrderService(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    @Override
    public void addOrder(Order order) {
        orderDAO.addOrder(order);
    }

    @Override
    public Order getOrderById(Long id) {
        return orderDAO.getOrderById(id);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderDAO.getAllOrders();
    }

    @Override
    public void deleteOrderById(Long id) {
        orderDAO.deleteOrderById(id);
    }
}
