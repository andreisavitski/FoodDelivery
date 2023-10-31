package by.pvt.fooddelivery.repository;

import by.pvt.fooddelivery.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
