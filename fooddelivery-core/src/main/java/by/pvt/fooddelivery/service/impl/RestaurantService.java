package by.pvt.fooddelivery.service.impl;

import by.pvt.fooddelivery.dao.RestaurantDAO;
import by.pvt.fooddelivery.domain.Restaurant;
import by.pvt.fooddelivery.service.RestaurantApi;

import java.util.List;

public class RestaurantService implements RestaurantApi {
    private final RestaurantDAO restaurantDAO;

    public RestaurantService(RestaurantDAO restaurantDAO) {
        this.restaurantDAO = restaurantDAO;
    }

    @Override
    public void addRestaurant(Restaurant restaurant) {
        restaurantDAO.addRestaurant(restaurant);
    }

    @Override
    public Restaurant getRestaurantById(Long id) {
        return restaurantDAO.getRestaurantById(id);
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        return restaurantDAO.getAllRestaurants();
    }

    @Override
    public void deleteRestaurantById(Long id) {
        restaurantDAO.deleteRestaurantById(id);
    }
}
