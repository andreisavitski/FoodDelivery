package by.pvt.fooddelivery.repository.impl.hibernate;

import by.pvt.fooddelivery.domain.Restaurant;
import by.pvt.fooddelivery.repository.RestaurantRepository;

import java.util.List;
import java.util.Optional;

public class RestaurantRepositoryHibernate extends RepositoryCRUD implements RestaurantRepository {
    @Override
    public void addRestaurant(Restaurant restaurant) {
        add(restaurant);
    }

    @Override
    public Optional<Restaurant> getRestaurantById(Long restaurantId) {
        return getById(Restaurant.class, restaurantId);
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        return getAll(Restaurant.class);
    }

    @Override
    public void deleteRestaurantById(Long restaurantId) {
        deleteById(Restaurant.class, restaurantId);
    }

    @Override
    public void updateRestaurant(Restaurant restaurant) {
        update(restaurant);
    }
}
