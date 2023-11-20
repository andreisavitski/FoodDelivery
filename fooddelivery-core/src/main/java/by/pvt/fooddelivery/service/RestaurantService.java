package by.pvt.fooddelivery.service;

import by.pvt.fooddelivery.dto.RestaurantDTO;

import java.util.List;

public interface RestaurantService {
    RestaurantDTO addRestaurant(RestaurantDTO restaurantDTO);

    void deleteRestaurantById(Long restaurantId);

    RestaurantDTO findRestaurantById(Long restaurantId);

    List<RestaurantDTO> findAllRestaurants();

    RestaurantDTO updateRestaurant(RestaurantDTO restaurantDTO);

}
