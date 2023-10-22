package by.pvt.fooddelivery.repository;

import by.pvt.fooddelivery.domain.Order;
import by.pvt.fooddelivery.domain.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface OrderRepository {
    void addOrder(Order order);

    Optional<Order> getOrderById(Long orderId);

    List<Order> getAllOrders();

    void deleteOrderById(Long orderId);

    void updateOrder(Order order);

    List<Product> getOrderProducts(Long orderId);

    void updateListProducts(Long orderId, List<Product> products);

    void updateTotalCost(Long orderId, BigDecimal totalCost);
}
