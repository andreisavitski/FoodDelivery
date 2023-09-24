package by.pvt.fooddelivery.service;

import by.pvt.fooddelivery.domain.user.RestaurantWorker;

import java.util.List;

public interface RestaurantWorkerApi {
    void addRestaurantWorker(RestaurantWorker restaurantWorker);

    RestaurantWorker getRestaurantWorkerById(Long id);

    List<RestaurantWorker> getAllRestaurantWorkers();

    void deleteRestaurantWorkerById(Long id);
}
