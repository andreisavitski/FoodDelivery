package by.pvt.fooddelivery.service;

import by.pvt.fooddelivery.dto.ProductDTO;

import java.util.List;

public interface ProductApi {
    void addProduct(ProductDTO productDTO);

    ProductDTO getProductById(Long productId);

    List<ProductDTO> gelAllProducts();

    void deleteProductById(Long productId);

    List<ProductDTO> getProductsByName(String productName);

    List<ProductDTO> getProductsByRestaurantName(String restaurantName);

    List<ProductDTO> getProductsByRestaurantId(Long restaurantId);

    void updateProduct(ProductDTO productDTO);

    List<ProductDTO> getProductsByProductNameAndRestaurantName(String productName, String restaurantName);
}
