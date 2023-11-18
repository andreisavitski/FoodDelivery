package by.pvt.fooddelivery.controller;

import by.pvt.fooddelivery.dto.ProductDTO;
import by.pvt.fooddelivery.enums.ProductType;
import by.pvt.fooddelivery.logging.Logging;
import by.pvt.fooddelivery.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
@RequiredArgsConstructor
public class ProductRestController {
    private final ProductService productService;

    @Logging
    @GetMapping
//    @PreAuthorize("hasAuthority('ADMIN')")
    public List<ProductDTO> getProducts() {
        return productService.findAllProducts();
    }

    @Logging
    @PostMapping
    public ProductDTO addProduct(@RequestBody @Validated ProductDTO dto) {
        return productService.addProduct(dto);
    }

    @Logging
    @GetMapping("{id}")
    public ProductDTO getProduct(@PathVariable("id") Long id) {
        return productService.findProductById(id);
    }

    @Logging
    @PutMapping
    public ProductDTO updateProduct(@RequestBody @Validated ProductDTO dto) {
        return productService.updateProduct(dto);
    }

    @Logging
    @DeleteMapping("{id}")
    public void deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProductById(id);
    }

    @Logging
    @PostMapping("restaurant/{id}")
    List<ProductDTO> findProductsByProductTypeAndRestaurantId(@RequestBody ProductType type, @PathVariable("id") Long restaurantId) {
        return productService.findProductsByProductTypeAndRestaurantId(type, restaurantId);
    }

    @Logging
    @GetMapping("restaurant/{id}")
    List<ProductDTO> findProductsByRestaurantId(@PathVariable("id") Long restaurantId) {
        return productService.findProductsByRestaurantId(restaurantId);
    }

    @Logging
    @PostMapping("name")
    List<ProductDTO> findProductsByName(@RequestBody String productName) {
        return productService.findProductsByName(productName);
    }

    @Logging
    @PostMapping("type")
    List<ProductDTO> findProductsByProductType(@RequestBody ProductType type) {
        return productService.findProductsByProductType(type);
    }
}
