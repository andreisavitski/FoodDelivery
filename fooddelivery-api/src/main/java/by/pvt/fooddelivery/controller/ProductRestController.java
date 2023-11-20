package by.pvt.fooddelivery.controller;

import by.pvt.fooddelivery.dto.ProductDTO;
import by.pvt.fooddelivery.enums.ProductType;
import by.pvt.fooddelivery.logging.MethodLogging;
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

    @MethodLogging
    @GetMapping
    public List<ProductDTO> getProducts() {
        return productService.findAllProducts();
    }

    @MethodLogging
    @PostMapping
    public ProductDTO addProduct(@RequestBody @Validated ProductDTO dto) {
        return productService.addProduct(dto);
    }

    @MethodLogging
    @GetMapping("{id}")
    public ProductDTO getProduct(@PathVariable("id") Long id) {
        return productService.findProductById(id);
    }

    @MethodLogging
    @PutMapping
    public ProductDTO updateProduct(@RequestBody @Validated ProductDTO dto) {
        return productService.updateProduct(dto);
    }

    @MethodLogging
    @DeleteMapping("{id}")
    public void deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProductById(id);
    }

    @MethodLogging
    @PostMapping("restaurant/{id}")
    List<ProductDTO> findProductsByProductTypeAndRestaurantId(@RequestBody ProductType type, @PathVariable("id") Long restaurantId) {
        return productService.findProductsByProductTypeAndRestaurantId(type, restaurantId);
    }

    @MethodLogging
    @GetMapping("restaurant/{id}")
    List<ProductDTO> findProductsByRestaurantId(@PathVariable("id") Long restaurantId) {
        return productService.findProductsByRestaurantId(restaurantId);
    }

    @MethodLogging
    @PostMapping("name")
    List<ProductDTO> findProductsByName(@RequestBody String productName) {
        return productService.findProductsByName(productName);
    }

    @MethodLogging
    @PostMapping("type")
    List<ProductDTO> findProductsByProductType(@RequestBody ProductType type) {
        return productService.findProductsByProductType(type);
    }
}
