package by.pvt.fooddelivery.mapper;

import by.pvt.fooddelivery.entity.Restaurant;
import by.pvt.fooddelivery.dto.RestaurantDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {AddressMapper.class, ProductMapper.class})
public interface RestaurantMapper {
    @Mapping(source = "addressDTO", target = "address")
    Restaurant toRestaurant(RestaurantDTO restaurantDTO);

    @Mapping(source = "address", target = "addressDTO")
    RestaurantDTO toDTO(Restaurant restaurant);
}
