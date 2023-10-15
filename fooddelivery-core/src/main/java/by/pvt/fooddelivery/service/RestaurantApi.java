package by.pvt.fooddelivery.service;

import by.pvt.fooddelivery.dto.RestaurantDTO;

import java.util.List;

public interface RestaurantApi {
    void addRestaurant(RestaurantDTO restaurantDTO);

    RestaurantDTO getRestaurantById(Long restaurantId);

    List<RestaurantDTO> getAllRestaurants();

    void deleteRestaurantById(Long restaurantId);

    void updateRestaurant(RestaurantDTO restaurantDTO);

}
