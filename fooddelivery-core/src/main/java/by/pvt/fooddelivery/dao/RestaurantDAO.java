package by.pvt.fooddelivery.dao;

import by.pvt.fooddelivery.domain.Restaurant;

import java.util.List;

public interface RestaurantDAO {
    void addRestaurant(Restaurant restaurant);

    Restaurant getRestaurantById(Long id);

    List<Restaurant> getAllRestaurants();

    void deleteRestaurantById(Long id);
}
