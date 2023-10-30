package by.pvt.fooddelivery.service;

import by.pvt.fooddelivery.dto.RestaurantDTO;

import java.util.List;

public interface RestaurantService {
    void addRestaurant(RestaurantDTO restaurantDTO);

    void deleteRestaurantById(Long restaurantId);

    RestaurantDTO findRestaurantById(Long restaurantId);

    List<RestaurantDTO> findAllRestaurants();

    void updateRestaurant(RestaurantDTO restaurantDTO);

}
