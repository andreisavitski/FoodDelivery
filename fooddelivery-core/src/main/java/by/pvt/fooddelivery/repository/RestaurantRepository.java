package by.pvt.fooddelivery.repository;

import by.pvt.fooddelivery.domain.Restaurant;

import java.util.List;
import java.util.Optional;

public interface RestaurantRepository {
    void addRestaurant(Restaurant restaurant);

    Optional<Restaurant> getRestaurantById(Long restaurantId);

    List<Restaurant> getAllRestaurants();

    void deleteRestaurantById(Long restaurantId);

    void updateRestaurant(Restaurant restaurant);
}
