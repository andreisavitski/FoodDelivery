package by.pvt.fooddelivery.service;

import by.pvt.fooddelivery.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    ProductDTO addProduct(ProductDTO productDTO);

    void deleteProductById(Long productId);

    ProductDTO findProductById(Long productId);

    List<ProductDTO> findAllProducts();

    List<ProductDTO> findProductsByName(String productName);

    List<ProductDTO> findProductsByRestaurantName(String restaurantName);

    List<ProductDTO> findProductsByRestaurantId(Long restaurantId);

    ProductDTO updateProduct(ProductDTO productDTO);
}
