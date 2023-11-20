package by.pvt.fooddelivery.service.impl;

import by.pvt.fooddelivery.dto.ProductDTO;
import by.pvt.fooddelivery.exception.ProductNotFoundException;
import by.pvt.fooddelivery.mapper.ProductMapper;
import by.pvt.fooddelivery.repository.ProductRepository;
import by.pvt.fooddelivery.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    @Transactional
    public ProductDTO addProduct(ProductDTO productDTO) {
        return productMapper.toDTO(productRepository.save(productMapper.toProduct(productDTO)));
    }

    @Override
    @Transactional
    public void deleteProductById(Long productId) {
        productRepository.deleteById(productId);
    }

    @Override
    public ProductDTO findProductById(Long productId) {
        return productMapper.toDTO(productRepository.findById(productId).orElseThrow(
                () -> new ProductNotFoundException("Product id " + productId + " not found")));
    }

    @Override
    public List<ProductDTO> findAllProducts() {
        return productRepository.findAll().stream().map(productMapper::toDTO).toList();
    }

    @Override
    public List<ProductDTO> findProductsByName(String productName) {
        return productRepository.findByName(productName).stream().map(productMapper::toDTO).toList();
    }

    @Override
    public List<ProductDTO> findProductsByRestaurantName(String restaurantName) {
        return productRepository.findByRestaurantName(restaurantName)
                .stream().map(productMapper::toDTO).toList();
    }

    @Override
    public List<ProductDTO> findProductsByRestaurantId(Long restaurantId) {
        return productRepository.findByRestaurantId(restaurantId).stream().map(productMapper::toDTO).toList();
    }

    @Override
    @Transactional
    public ProductDTO updateProduct(ProductDTO productDTO) {
        return productMapper.toDTO(productRepository.save(productMapper.toProduct(productDTO)));
    }
}
