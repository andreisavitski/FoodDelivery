package by.pvt.fooddelivery.repository.product.interfaces;

import by.pvt.fooddelivery.entity.Product;
import by.pvt.fooddelivery.enums.ProductType;
import lombok.NonNull;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {
    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH, value = "product_entity-graph")
    List<Product> findByNameContains(String productName);

    List<Product> findByTypeAndRestaurantId(ProductType type, Long restaurantId);

    List<Product> findByTypeAndRestaurantIdAndNameContains(ProductType type, Long restaurantId, String name);

    List<Product> findByRestaurantId(Long restaurantId);

    List<Product> findByType(ProductType type);

    @NonNull
    List<Product> findAll(@NonNull Specification<Product> spec);
}
