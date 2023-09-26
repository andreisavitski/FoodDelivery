package by.pvt.fooddelivery.dao;

import by.pvt.fooddelivery.domain.user.RestaurantWorker;

import java.util.List;

public interface RestaurantWorkerDAO {
    void addRestaurantWorker(RestaurantWorker restaurantWorker);

    RestaurantWorker getRestaurantWorkerById(Long id);

    List<RestaurantWorker> getAllRestaurantWorkers();

    void deleteRestaurantWorkerById(Long id);
}
