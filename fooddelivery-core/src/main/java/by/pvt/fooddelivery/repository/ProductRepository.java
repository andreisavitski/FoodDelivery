package by.pvt.fooddelivery.repository;

import by.pvt.fooddelivery.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    void addFood(Product product);

    Optional<Product> getProductById(Long productId);

    List<Product> gelAllProducts();

    void deleteProductById(Long productId);

    List<Product> getProductsByName(String productName);

    List<Product> getProductsByProductNameAndRestaurantName(String productName, String restaurantName);

    List<Product> getProductsByRestaurantName(String restaurantName);

    List<Product> getProductsByRestaurantId(Long restaurantId);

    void updateProduct(Product product);
}
