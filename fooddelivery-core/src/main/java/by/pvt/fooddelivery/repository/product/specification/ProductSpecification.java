package by.pvt.fooddelivery.repository.product.specification;

import by.pvt.fooddelivery.entity.Product;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

public final class ProductSpecification {
    private ProductSpecification() {
    }

    public static Specification<Product> filterProductByName(String name) {
        return (root, query, criteriaBuilder) -> {
            Predicate namePredicate = criteriaBuilder.like(root.get("name"), likePattern(name));
            return criteriaBuilder.and(namePredicate);
        };
    }

    private static String likePattern(String name) {
        return "%" + name + "%";
    }
}
