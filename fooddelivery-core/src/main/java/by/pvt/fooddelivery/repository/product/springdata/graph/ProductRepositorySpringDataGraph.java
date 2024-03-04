package by.pvt.fooddelivery.repository.product.springdata.graph;

import by.pvt.fooddelivery.domain.Product;
import by.pvt.fooddelivery.enums.ProductType;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepositorySpringDataGraph extends JpaRepository<Product, Long> {
    List<Product> findByNameContains(String productName);

    List<Product> findByTypeAndRestaurantId(ProductType type, Long restaurantId);

    @EntityGraph(attributePaths = {"item"})
    List<Product> findByTypeAndRestaurantIdAndNameContains(ProductType type, Long restaurantId, String name);

    List<Product> findByRestaurantId(Long restaurantId);

    List<Product> findByType(ProductType type);
}
