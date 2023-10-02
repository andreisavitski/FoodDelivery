package by.pvt.fooddelivery.service.impl;

import by.pvt.fooddelivery.domain.Restaurant;
import by.pvt.fooddelivery.repository.RestaurantRepository;
import by.pvt.fooddelivery.service.RestaurantApi;

import java.util.List;

public class RestaurantService implements RestaurantApi {
    private final RestaurantRepository restaurantRepository;

    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public void addRestaurant(Restaurant restaurant) {
        restaurantRepository.addRestaurant(restaurant);
    }

    @Override
    public Restaurant getRestaurantById(Long restaurantId) {
        return restaurantRepository.getRestaurantById(restaurantId).orElseThrow(
                () -> new RuntimeException("Restaurant does not exist"));
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.getAllRestaurants();
    }

    @Override
    public void deleteRestaurantById(Long restaurantId) {
        restaurantRepository.deleteRestaurantById(restaurantId);
    }

    @Override
    public void updateRestaurant(Restaurant restaurant) {
        restaurantRepository.updateRestaurant(restaurant);
    }
}
