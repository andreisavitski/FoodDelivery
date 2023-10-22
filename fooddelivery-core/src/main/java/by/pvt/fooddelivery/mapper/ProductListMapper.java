package by.pvt.fooddelivery.mapper;

import by.pvt.fooddelivery.domain.Product;
import by.pvt.fooddelivery.dto.ProductDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface ProductListMapper {
    List<Product> toProducts(List<ProductDTO> productDTOS);
    List<ProductDTO> toProductDTOS(List<Product> products);
}
