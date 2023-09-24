package by.pvt.fooddelivery.service.impl;

import by.pvt.fooddelivery.dao.RestaurantWorkerDAO;
import by.pvt.fooddelivery.domain.user.RestaurantWorker;
import by.pvt.fooddelivery.service.RestaurantWorkerApi;

import java.util.List;

public class RestaurantWorkerService implements RestaurantWorkerApi {
    private final RestaurantWorkerDAO restaurantWorkerDAO;

    public RestaurantWorkerService(RestaurantWorkerDAO restaurantWorkerDAO) {
        this.restaurantWorkerDAO = restaurantWorkerDAO;
    }

    @Override
    public void addRestaurantWorker(RestaurantWorker restaurantWorker) {
        restaurantWorkerDAO.addRestaurantWorker(restaurantWorker);

    }

    @Override
    public RestaurantWorker getRestaurantWorkerById(Long id) {
        return restaurantWorkerDAO.getRestaurantWorkerById(id);
    }

    @Override
    public List<RestaurantWorker> getAllRestaurantWorkers() {
        return restaurantWorkerDAO.getAllRestaurantWorkers();
    }

    @Override
    public void deleteRestaurantWorkerById(Long id) {
        restaurantWorkerDAO.deleteRestaurantWorkerById(id);
    }
}
