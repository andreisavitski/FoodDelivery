package by.pvt.fooddelivery.service.impl;

import by.pvt.fooddelivery.dto.ProductDTO;
import by.pvt.fooddelivery.mapper.ProductMapper;
import by.pvt.fooddelivery.repository.ProductRepository;
import by.pvt.fooddelivery.service.ProductApi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService implements ProductApi {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public void addProduct(ProductDTO productDTO) {
        productRepository.addFood(productMapper.toProduct(productDTO));
    }

    @Override
    public ProductDTO getProductById(Long productId) {
        return productMapper.toDTO(productRepository.getProductById(productId).orElseThrow(
                () -> new RuntimeException("Food does not exist")));
    }

    @Override
    public List<ProductDTO> gelAllProducts() {
        return productRepository.gelAllProducts().stream().map(productMapper::toDTO).toList();
    }

    @Override
    public void deleteProductById(Long productId) {
        productRepository.deleteProductById(productId);
    }

    @Override
    public List<ProductDTO> getProductsByName(String productName) {
        return productRepository.getProductsByName(productName).stream().map(productMapper::toDTO).toList();
    }

    @Override
    public List<ProductDTO> getProductsByRestaurantName(String restaurantName) {
        return productRepository.getProductsByRestaurantName(restaurantName)
                .stream().map(productMapper::toDTO).toList();
    }

    @Override
    public List<ProductDTO> getProductsByRestaurantId(Long restaurantId) {
        return productRepository.getProductsByRestaurantId(restaurantId).stream().map(productMapper::toDTO).toList();
    }

    @Override
    public void updateProduct(ProductDTO productDTO) {
        productRepository.updateProduct(productMapper.toProduct(productDTO));
    }

    @Override
    public List<ProductDTO> getProductsByProductNameAndRestaurantName(String productName, String restaurantName) {
        return productRepository.getProductsByProductNameAndRestaurantName(productName, restaurantName)
                .stream().map(productMapper::toDTO).toList();
    }
}
