package by.pvt.fooddelivery.repository.impl.hibernate;

import by.pvt.fooddelivery.domain.Order;
import by.pvt.fooddelivery.repository.OrderRepository;

import java.util.List;
import java.util.Optional;

public class OrderRepositoryHibernate extends RepositoryCRUD implements OrderRepository {
    @Override
    public void addOrder(Order order) {
        add(order);
    }

    @Override
    public Optional<Order> getOrderById(Long orderId) {
        return getById(Order.class, orderId);
    }

    @Override
    public List<Order> getAllOrders() {
        return getAll(Order.class);
    }

    @Override
    public void deleteOrderById(Long orderId) {
        deleteById(Order.class, orderId);
    }

    @Override
    public void updateOrder(Order order) {
        update(order);
    }
}
