package by.pvt.fooddelivery.repository.product.graph;

import by.pvt.fooddelivery.domain.Product;
import by.pvt.fooddelivery.enums.ProductType;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepositoryGraph1v extends JpaRepository<Product, Long> {
    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH, attributePaths = "restaurant")
    List<Product> findByNameContains(String productName);

    List<Product> findByTypeAndRestaurantId(ProductType type, Long restaurantId);

    List<Product> findByTypeAndRestaurantIdAndNameContains(ProductType type, Long restaurantId, String name);

    List<Product> findByRestaurantId(Long restaurantId);

    List<Product> findByType(ProductType type);
}
