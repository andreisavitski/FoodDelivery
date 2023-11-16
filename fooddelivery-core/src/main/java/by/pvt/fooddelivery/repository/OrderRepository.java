package by.pvt.fooddelivery.repository;

import by.pvt.fooddelivery.domain.Order;
import by.pvt.fooddelivery.enums.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByOrderStatus(OrderStatus orderStatus);
}
