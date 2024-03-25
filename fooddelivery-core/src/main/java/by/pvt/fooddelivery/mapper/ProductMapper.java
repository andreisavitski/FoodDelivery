package by.pvt.fooddelivery.mapper;

import by.pvt.fooddelivery.entity.Product;
import by.pvt.fooddelivery.dto.ProductDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = RestaurantMapper.class)
public interface ProductMapper {
    @Mapping(source = "restaurantDTO", target = "restaurant")
    Product toProduct(ProductDTO productDTO);

    @Mapping(source = "restaurant", target = "restaurantDTO")
    ProductDTO toDTO(Product product);
}
