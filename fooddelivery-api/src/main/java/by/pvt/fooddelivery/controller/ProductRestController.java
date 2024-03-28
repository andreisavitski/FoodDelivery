package by.pvt.fooddelivery.controller;

import by.pvt.fooddelivery.dto.ProductDTO;
import by.pvt.fooddelivery.dto.ProductGetterDTO;
import by.pvt.fooddelivery.dto.ProductGetterWithNameDTO;
import by.pvt.fooddelivery.dto.ProductPaginationDTO;
import by.pvt.fooddelivery.enums.ProductType;
import by.pvt.fooddelivery.service.ProductService;
import by.pvt.loggingaspect.MethodLogging;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
@Tag(name = "PRODUCT", description = "Allows you to manage products")
public class ProductRestController {

    private final ProductService productService;

    @MethodLogging
    @GetMapping
    @Operation(summary = "Get all products", security = @SecurityRequirement(name = "bearerAuth"))
    public Page<ProductDTO> getProducts(@RequestBody ProductPaginationDTO dto) {
        return productService.findAllProducts(dto.getOffset(), dto.getPageSize(), dto.getField());
    }

    @MethodLogging
    @PostMapping("/namespec")
    @Operation(summary = "Get products by name with specification", security = @SecurityRequirement(name = "bearerAuth"))
    public List<ProductDTO> getProductsByNameWithSpecification(@RequestBody String name) {
        return productService.findByNameWithSpecification(name);
    }

    @Operation(summary = "Add a product", security = @SecurityRequirement(name = "bearerAuth"))
    @MethodLogging
    @PostMapping
    public ProductDTO addProduct(@RequestBody @Validated ProductDTO dto) {
        return productService.addProduct(dto);
    }

    @Operation(summary = "Get a product by ID", security = @SecurityRequirement(name = "bearerAuth"))
    @MethodLogging
    @GetMapping("/{id}")
    public ProductDTO getProduct(@PathVariable("id") Long id) {
        return productService.findProductById(id);
    }

    @Operation(summary = "Change product", security = @SecurityRequirement(name = "bearerAuth"))
    @MethodLogging
    @PutMapping
    public ProductDTO updateProduct(@RequestBody @Validated ProductDTO dto) {
        return productService.updateProduct(dto);
    }

    @Operation(summary = "Delete product", security = @SecurityRequirement(name = "bearerAuth"))
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProductById(id);
    }

    @Operation(summary = "Get products by type and restaurant ID", security = @SecurityRequirement(name = "bearerAuth"))
    @MethodLogging
    @PostMapping("/restaurant")
    public List<ProductDTO> findProductsByProductTypeAndRestaurantId(@RequestBody ProductGetterDTO dto) {
        return productService.findProductsByProductTypeAndRestaurantId(
                ProductType.valueOf(dto.getType()), dto.getRestaurantId()
        );
    }

    @Operation(summary = "Get products by type and restaurant ID and name",
            security = @SecurityRequirement(name = "bearerAuth"))
    @MethodLogging
    @PostMapping("/name/restaurant")
    public List<ProductDTO> findProductsByProductTypeAndRestaurantIdAndName(@RequestBody ProductGetterWithNameDTO dto) {
        return productService.findByTypeAndRestaurantIdAndName(
                ProductType.valueOf(dto.getType()), dto.getRestaurantId(), dto.getName()
        );
    }

    @Operation(summary = "Receive products using restaurant ID", security = @SecurityRequirement(name = "bearerAuth"))
    @MethodLogging
    @GetMapping("/restaurant/{id}")
    public List<ProductDTO> findProductsByRestaurantId(@PathVariable("id") Long restaurantId) {
        return productService.findProductsByRestaurantId(restaurantId);
    }

    @Operation(summary = "Get products by name", security = @SecurityRequirement(name = "bearerAuth"))
    @MethodLogging
    @PostMapping("/name")
    public List<ProductDTO> findProductsByName(@RequestBody String productName) {
        return productService.findProductsByName(productName);
    }

    @Operation(summary = "Get products by type", security = @SecurityRequirement(name = "bearerAuth"))
    @MethodLogging
    @PostMapping("/type")
    public List<ProductDTO> findProductsByProductType(@RequestBody ProductType type) {
        return productService.findProductsByProductType(type);
    }

    @Operation(summary = "Receive products using restaurant ID with Jdbc Template",
            security = @SecurityRequirement(name = "bearerAuth"))
    @MethodLogging
    @GetMapping("/jdbc/restaurant/{id}")
    public List<ProductDTO> findProductsByRestaurantIdWithJdbcTemplate(@PathVariable("id") Long restaurantId) {
        return productService.findProductsByRestaurantIdWithJdbcTemplate(restaurantId);
    }

    @Operation(summary = "Get products by type and restaurant ID and name with Criteria",
            security = @SecurityRequirement(name = "bearerAuth"))
    @MethodLogging
    @PostMapping("/criteria/name/restaurant")
    public List<ProductDTO> findProductsByProductTypeAndRestaurantIdAndNameWithCriteria(
            @RequestBody ProductGetterWithNameDTO dto) {
        return productService.findProductsByRestaurantIdWithCriteria(
                ProductType.valueOf(dto.getType()), dto.getRestaurantId(), dto.getName()
        );
    }
}
