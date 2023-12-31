package by.pvt.fooddelivery.repository;

import by.pvt.fooddelivery.domain.Product;
import by.pvt.fooddelivery.enums.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT p FROM Product p WHERE p.name ILIKE %:productName%")
    List<Product> findByName(@Param("productName") String productName);

    List<Product> findByTypeAndRestaurantId(ProductType type, Long restaurantId);

    List<Product> findByRestaurantId(Long restaurantId);

    List<Product> findByType(ProductType type);
}
