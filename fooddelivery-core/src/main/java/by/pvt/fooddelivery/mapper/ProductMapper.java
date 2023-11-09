package by.pvt.fooddelivery.mapper;

import by.pvt.fooddelivery.domain.Product;
import by.pvt.fooddelivery.dto.ProductDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = RestaurantMapper.class)
public interface ProductMapper {
    @Mapping(source = "restaurantName", target = "restaurant.name")
    Product toProduct(ProductDTO productDTO);

    @Mapping(source = "restaurant.name", target = "restaurantName")
    ProductDTO toDTO(Product product);
}
