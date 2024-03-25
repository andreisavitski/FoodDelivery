package by.pvt.fooddelivery.repository.product.criteria;

import by.pvt.fooddelivery.entity.Product;
import by.pvt.fooddelivery.entity.Product_;
import by.pvt.fooddelivery.entity.Restaurant;
import by.pvt.fooddelivery.entity.Restaurant_;
import by.pvt.fooddelivery.enums.ProductType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CriteriaProductRepositoryImpl implements CriteriaProductRepository {

    private final EntityManager em;

    @Override
    public List<Product> findByTypeAndRestaurantIdAndNameContains(ProductType type, Long restaurantId, String name) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Product> cq = cb.createQuery(Product.class);
        Root<Product> root = cq.from(Product.class);
        root.fetch(Product_.RESTAURANT, JoinType.LEFT);
        Join<Product, Restaurant> restaurant = root.join("restaurant");
        cq.select(root)
                .where(
                        cb.equal(
                                restaurant.get(Restaurant_.ID),
                                restaurantId
                        ),
                        cb.equal(
                                root.get(Product_.TYPE),
                                type
                        ),
                        cb.like(
                                root.get(Product_.NAME),
                                "%" + name + "%"
                        )
                );
        return em.createQuery(cq).getResultList();
    }
}
