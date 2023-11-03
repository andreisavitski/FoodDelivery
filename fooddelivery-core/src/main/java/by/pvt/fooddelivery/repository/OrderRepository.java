package by.pvt.fooddelivery.repository;

import by.pvt.fooddelivery.domain.Order;
import by.pvt.fooddelivery.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query(value = "select p from Order o join o.products p where o.id = :orderId")
    List<Product> findProductById(@Param("orderId") Long orderId);
}
