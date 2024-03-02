package by.pvt.fooddelivery.service.impl;

import by.pvt.fooddelivery.domain.Product;
import by.pvt.fooddelivery.domain.Restaurant;
import by.pvt.fooddelivery.dto.ProductDTO;
import by.pvt.fooddelivery.enums.ProductType;
import by.pvt.fooddelivery.exception.ApplicationException;
import by.pvt.fooddelivery.mapper.ProductMapper;
import by.pvt.fooddelivery.repository.ProductRepository;
import by.pvt.fooddelivery.repository.RestaurantRepository;
import by.pvt.fooddelivery.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static by.pvt.fooddelivery.exception.ApplicationError.*;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final RestaurantRepository restaurantRepository;
    private final ProductMapper productMapper;

    @Override
    @Transactional
    public ProductDTO addProduct(ProductDTO productDTO) {
        Product product = productMapper.toProduct(productDTO);
        product.setRestaurant(restaurantRepository.findById(productDTO.getRestaurantDTO().getId()).orElseThrow(
                () -> new ApplicationException(RESTAURANT_NOT_FOUND)
        ));
        return productMapper.toDTO(
                productRepository.save(
                        productMapper.toProduct(
                                checkUniqueName(productDTO)
                        )
                )
        );
    }

    @Override
    @Transactional
    public void deleteProductById(Long productId) {
        productRepository.delete(productMapper.toProduct(findProductById(productId)));
    }

    @Override
    public ProductDTO findProductById(Long productId) {
        return productMapper.toDTO(productRepository.findById(productId).orElseThrow(
                () -> new ApplicationException(PRODUCT_NOT_FOUND)
        ));
    }

    @Cacheable("products")
    @Override
    public List<ProductDTO> findAllProducts() {
        return productRepository.findAll().stream()
                .map(productMapper::toDTO)
                .toList();
    }

    @Override
    public List<ProductDTO> findProductsByName(String productName) {
        return productRepository.findByNameContains(productName).stream()
                .map(productMapper::toDTO)
                .toList();
    }

    @Override
    public List<ProductDTO> findProductsByProductTypeAndRestaurantId(ProductType type, Long restaurantId) {
        return productRepository.findByTypeAndRestaurantId(type, restaurantId).stream()
                .map(productMapper::toDTO)
                .toList();
    }

    @Override
    public List<ProductDTO> findProductsByProductType(ProductType type) {
        return productRepository.findByType(type).stream()
                .map(productMapper::toDTO)
                .toList();
    }

    @Override
    public List<ProductDTO> findProductsByRestaurantId(Long restaurantId) {
        return productRepository.findByRestaurantId(restaurantId).stream()
                .map(productMapper::toDTO)
                .toList();
    }

    @Override
    @Transactional
    public ProductDTO updateProduct(ProductDTO productDTO) {
        findProductById(productDTO.getId());
        return productMapper.toDTO(
                productRepository.save(
                        productMapper.toProduct(
                                checkUniqueName(productDTO)
                        )
                )
        );
    }

    private ProductDTO checkUniqueName(ProductDTO productDTO) {
        Product product = productRepository.findById(productDTO.getId()).orElseThrow(
                () -> new ApplicationException(PRODUCT_NOT_FOUND)
        );
        Restaurant restaurant = restaurantRepository.findById(product.getRestaurant().getId())
                .orElseThrow(() -> new ApplicationException(RESTAURANT_NOT_FOUND));
        if (!restaurant.getProducts().stream()
                .filter(p -> p.getName().equals(productDTO.getName()))
                .toList()
                .isEmpty()) {
            throw new ApplicationException(PRODUCT_NOT_ADDED);
        }
        product.setRestaurant(restaurant);
        return productMapper.toDTO(product);
    }
}
