package by.pvt.fooddelivery.service;

import by.pvt.fooddelivery.domain.Product;

import java.util.List;

public interface ProductApi {
    void addProduct(Product product);

    Product getProductById(Long productId);

    List<Product> gelAllProducts();

    void deleteProductById(Long productId);

    List<Product> getProductsByName(String productName);

    List<Product> getProductsByRestaurantName(String restaurantName);

    List<Product> getProductsByRestaurantId(Long restaurantId);

    void updateProduct(Product product);

    List<Product> getProductsByProductNameAndRestaurantName(String productName, String restaurantName);
}
