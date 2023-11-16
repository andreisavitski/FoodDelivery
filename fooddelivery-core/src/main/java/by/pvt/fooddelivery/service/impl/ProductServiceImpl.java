package by.pvt.fooddelivery.service.impl;

import by.pvt.fooddelivery.dto.ProductDTO;
import by.pvt.fooddelivery.enums.ProductType;
import by.pvt.fooddelivery.exception.ApplicationException;
import by.pvt.fooddelivery.mapper.ProductMapper;
import by.pvt.fooddelivery.repository.ProductRepository;
import by.pvt.fooddelivery.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static by.pvt.fooddelivery.exception.ApplicationError.PRODUCT_NOT_FOUND;

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
        productRepository.delete(productMapper.toProduct(findProductById(productId)));
    }

    @Override
    public ProductDTO findProductById(Long productId) {
        return productMapper.toDTO(productRepository.findById(productId).orElseThrow(() -> new ApplicationException(PRODUCT_NOT_FOUND)));
    }

    @Override
    public List<ProductDTO> findAllProducts() {
        List<ProductDTO> products = productRepository.findAll().stream().map(productMapper::toDTO).toList();
        if (products.isEmpty()) {
            throw new ApplicationException(PRODUCT_NOT_FOUND);
        }
        return products;
    }

    @Override
    public List<ProductDTO> findProductsByName(String productName) {
        return productRepository.findByName(productName).stream().map(productMapper::toDTO).toList();
    }

    @Override
    public List<ProductDTO> findProductsByProductTypeAndRestaurantId(ProductType type, Long restaurantId) {
        return productRepository.findByTypeAndRestaurantId(type, restaurantId)
                .stream().map(productMapper::toDTO).toList();
    }

    @Override
    public List<ProductDTO> findProductsByProductType(ProductType type) {
        return productRepository.findByType(type).stream().map(productMapper::toDTO).toList();
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
