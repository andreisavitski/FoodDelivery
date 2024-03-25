package by.pvt.fooddelivery.repository.product.criteria;

import by.pvt.fooddelivery.entity.Product;
import by.pvt.fooddelivery.enums.ProductType;

import java.util.List;

public interface CriteriaProductRepository {
    List<Product> findByTypeAndRestaurantIdAndNameContains(ProductType type, Long restaurantId, String name);
}
