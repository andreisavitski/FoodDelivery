package by.pvt.fooddelivery.repository.product.springdata.interfaces;

import by.pvt.fooddelivery.domain.Product;
import by.pvt.fooddelivery.enums.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByNameContains(String productName);

    List<Product> findByTypeAndRestaurantId(ProductType type, Long restaurantId);

    List<Product> findByTypeAndRestaurantIdAndNameContains(ProductType type, Long restaurantId, String name);

    List<Product> findByRestaurantId(Long restaurantId);

    List<Product> findByType(ProductType type);
}