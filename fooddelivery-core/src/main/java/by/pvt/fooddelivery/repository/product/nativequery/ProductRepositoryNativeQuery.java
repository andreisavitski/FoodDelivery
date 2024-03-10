package by.pvt.fooddelivery.repository.product.nativequery;

import by.pvt.fooddelivery.domain.Product;
import by.pvt.fooddelivery.enums.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepositoryNativeQuery extends JpaRepository<Product, Long> {
    List<Product> findByNameContains(String productName);

    List<Product> findByTypeAndRestaurantId(ProductType type, Long restaurantId);

    @Query(value = "select p.* from fooddeliverysch.product p " +
            "join fooddeliverysch.restaurant r on p.restaurant_id = r.id " +
            "where p.type = :#{#type.name()} and r.id = :restaurantId and p.name like %:name%",
            nativeQuery = true)
    List<Product> findByTypeAndRestaurantIdAndNameContains(@Param("type") ProductType type,
                                                           @Param("restaurantId") Long restaurantId,
                                                           @Param("name") String name);

    List<Product> findByRestaurantId(Long restaurantId);

    List<Product> findByType(ProductType type);
}
