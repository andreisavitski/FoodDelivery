package by.pvt.fooddelivery.service.impl;

import by.pvt.fooddelivery.domain.Product;
import by.pvt.fooddelivery.domain.Restaurant;
import by.pvt.fooddelivery.dto.ProductDTO;
import by.pvt.fooddelivery.enums.ProductType;
import by.pvt.fooddelivery.exception.ApplicationException;
import by.pvt.fooddelivery.mapper.ProductMapper;
import by.pvt.fooddelivery.repository.RestaurantRepository;
import by.pvt.fooddelivery.repository.product.interfaces.ProductRepository;
import by.pvt.fooddelivery.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static by.pvt.fooddelivery.exception.ApplicationError.*;
import static by.pvt.fooddelivery.repository.product.specification.ProductSpecification.filterProductByName;

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
        return productMapper.toDTO(productRepository.save((checkUniqueName(product))));
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
    public Page<ProductDTO> findAllProducts(Long offset, Long pageSize, String field) {
        List<ProductDTO> productDTOS = productRepository.findAll(PageRequest.of(Math.toIntExact(offset),
                        Math.toIntExact(pageSize)).withSort(Sort.by(field))).stream()
                .map(productMapper::toDTO)
                .toList();
        return new PageImpl<>(productDTOS);
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
    public List<ProductDTO> findByTypeAndRestaurantIdAndName(ProductType type, Long restaurantId, String name) {
        return productRepository.findByTypeAndRestaurantIdAndNameContains(type, restaurantId, name).stream()
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
        Product product = productMapper.toProduct(findProductById(productDTO.getId()));
        return productMapper.toDTO(productRepository.save(checkUniqueName(product)));
    }

    @Override
    public List<ProductDTO> findByNameWithSpecification(String name) {
        Specification<Product> productSpecification = filterProductByName(name);
        List<Product> products = productRepository.findAll(productSpecification);
        return products.stream()
                .map(productMapper::toDTO)
                .toList();
    }

    private Product checkUniqueName(Product product) {
        Restaurant restaurant = restaurantRepository.findById(product.getRestaurant().getId())
                .orElseThrow(() -> new ApplicationException(RESTAURANT_NOT_FOUND));
        if (!restaurant.getProducts().stream()
                .filter(p -> p.getName().equals(product.getName()))
                .toList()
                .isEmpty()) {
            throw new ApplicationException(PRODUCT_NOT_ADDED);
        }
        return product;
    }
}
