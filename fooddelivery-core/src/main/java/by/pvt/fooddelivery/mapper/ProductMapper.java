package by.pvt.fooddelivery.mapper;

import by.pvt.fooddelivery.domain.Product;
import by.pvt.fooddelivery.dto.ProductDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = RestaurantMapper.class)
public interface ProductMapper {
    Product toProduct(ProductDTO productDTO);

    ProductDTO toDTO(Product product);
}
