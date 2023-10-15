package by.pvt.fooddelivery.mapper;

import by.pvt.fooddelivery.domain.Restaurant;
import by.pvt.fooddelivery.dto.RestaurantDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = AddressMapper.class)
public interface RestaurantMapper {
    Restaurant toRestaurant(RestaurantDTO restaurantDTO);

    RestaurantDTO toDTO(Restaurant restaurant);
}
