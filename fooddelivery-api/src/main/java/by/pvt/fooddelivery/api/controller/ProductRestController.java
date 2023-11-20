package by.pvt.fooddelivery.api.controller;

import by.pvt.fooddelivery.dto.ProductDTO;
import by.pvt.fooddelivery.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductRestController {
    private final ProductService productService;

    @GetMapping("/getAll")
    public List<ProductDTO> getProducts() {
        return productService.findAllProducts();
    }


    @PostMapping("/addProduct")
    public ProductDTO addProduct(@RequestBody ProductDTO dto) {
        return productService.addProduct(dto);
    }

    @GetMapping("/getProduct/{id}")
    public ProductDTO getProduct(@PathVariable("id") Long id) {
        return productService.findProductById(id);
    }

    @PutMapping("/updateProduct")
    public ProductDTO updateProduct(@RequestBody ProductDTO dto) {
        return productService.updateProduct(dto);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public void deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProductById(id);
    }

}
