package by.pvt.fooddelivery.api.controller;

import by.pvt.fooddelivery.dto.ProductDTO;
import by.pvt.fooddelivery.enums.ProductType;
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

    @GetMapping
    public List<ProductDTO> getProducts() {
        return productService.findAllProducts();
    }

    @PostMapping
    public ProductDTO addProduct(@RequestBody @Validated ProductDTO dto) {
        return productService.addProduct(dto);
    }

    @GetMapping("{id}")
    public ProductDTO getProduct(@PathVariable("id") Long id) {
        return productService.findProductById(id);
    }

    @PutMapping
    public ProductDTO updateProduct(@RequestBody @Validated ProductDTO dto) {
        return productService.updateProduct(dto);
    }

    @DeleteMapping("{id}")
    public void deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProductById(id);
    }

    @PostMapping("restaurant/{id}")
    List<ProductDTO> findProductsByProductTypeAndRestaurantId(@RequestBody ProductType type, @PathVariable("id") Long restaurantId) {
        return productService.findProductsByProductTypeAndRestaurantId(type, restaurantId);
    }

    @GetMapping("restaurant/{id}")
    List<ProductDTO> findProductsByRestaurantId(@PathVariable("id") Long restaurantId) {
        return productService.findProductsByRestaurantId(restaurantId);

    }

    @PostMapping("name")
    List<ProductDTO> findProductsByName(@RequestBody String productName) {
        return productService.findProductsByName(productName);
    }

    @PostMapping("type")
    List<ProductDTO> findProductsByProductType(@RequestBody ProductType type) {
        return productService.findProductsByProductType(type);
    }
}
