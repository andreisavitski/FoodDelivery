package by.pvt.fooddelivery.service.impl;

import by.pvt.fooddelivery.domain.Product;
import by.pvt.fooddelivery.repository.ProductRepository;
import by.pvt.fooddelivery.service.ProductApi;

import java.util.List;

public class ProductService implements ProductApi {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void addProduct(Product product) {
        productRepository.addFood(product);
    }

    @Override
    public Product getProductById(Long productId) {
        return productRepository.getProductById(productId).orElseThrow(
                () -> new RuntimeException("Food does not exist"));
    }

    @Override
    public List<Product> gelAllProducts() {
        return productRepository.gelAllProducts();
    }

    @Override
    public void deleteProductById(Long productId) {
        productRepository.deleteProductById(productId);
    }

    @Override
    public List<Product> getProductsByName(String productName) {
        return productRepository.getProductsByName(productName);
    }

    @Override
    public List<Product> getProductsByRestaurantName(String restaurantName) {
        return productRepository.getProductsByRestaurantName(restaurantName);
    }

    @Override
    public List<Product> getProductsByRestaurantId(Long restaurantId) {
        return productRepository.getProductsByRestaurantId(restaurantId);
    }

    @Override
    public void updateProduct(Product product) {
        productRepository.updateProduct(product);
    }

    @Override
    public List<Product> getProductsByProductNameAndRestaurantName(String productName, String restaurantName) {
        return productRepository.getProductsByProductNameAndRestaurantName(productName, restaurantName);
    }
}
