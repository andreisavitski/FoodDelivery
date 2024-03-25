package by.pvt.fooddelivery.repository.product.jdbctemplate;

import by.pvt.fooddelivery.entity.Product;

import java.util.List;

public interface JdbcTemplateProductRepository {
    List<Product> findByRestaurantId(Long restaurantId);
}
