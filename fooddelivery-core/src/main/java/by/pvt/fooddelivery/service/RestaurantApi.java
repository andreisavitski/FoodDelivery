package by.pvt.fooddelivery.service;

import by.pvt.fooddelivery.domain.Restaurant;

import java.util.List;

public interface RestaurantApi {
    void addRestaurant(Restaurant restaurant);

    Restaurant getRestaurantById(Long restaurantId);

    List<Restaurant> getAllRestaurants();

    void deleteRestaurantById(Long restaurantId);

    void updateRestaurant(Restaurant restaurant);

}