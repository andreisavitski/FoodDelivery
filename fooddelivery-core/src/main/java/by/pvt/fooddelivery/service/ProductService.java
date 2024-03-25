package by.pvt.fooddelivery.service;

import by.pvt.fooddelivery.dto.ProductDTO;
import by.pvt.fooddelivery.enums.ProductType;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {
    ProductDTO addProduct(ProductDTO productDTO);

    void deleteProductById(Long productId);

    ProductDTO findProductById(Long productId);

    Page<ProductDTO> findAllProducts(Long offset, Long pageSize, String field);

    List<ProductDTO> findProductsByName(String productName);

    List<ProductDTO> findProductsByProductTypeAndRestaurantId(ProductType type, Long restaurantId);

    List<ProductDTO> findByTypeAndRestaurantIdAndName(ProductType type, Long restaurantId, String name);

    List<ProductDTO> findProductsByProductType(ProductType type);

    List<ProductDTO> findProductsByRestaurantId(Long restaurantId);

    ProductDTO updateProduct(ProductDTO productDTO);

    List<ProductDTO> findByNameWithSpecification(String name);

    List<ProductDTO> findProductsByRestaurantIdWithJdbcTemplate(Long restaurantId);

    List<ProductDTO> findProductsByRestaurantIdWithCriteria(ProductType type, Long restaurantId, String name);
}
