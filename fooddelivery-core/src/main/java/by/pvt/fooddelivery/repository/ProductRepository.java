package by.pvt.fooddelivery.repository;

import by.pvt.fooddelivery.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByName(String productName);

    List<Product> findByRestaurantName(String restaurantName);

    List<Product> findByRestaurantId(Long restaurantId);

    List<Product> findByOrdersId(Long orderId);
}
