package by.pvt.fooddelivery.repository;

import by.pvt.fooddelivery.domain.user.RestaurantEmployee;

import java.util.List;
import java.util.Optional;

public interface RestaurantEmployeeRepository {
    void addRestaurantEmployee(RestaurantEmployee restaurantEmployee);

    Optional<RestaurantEmployee> getRestaurantEmployeeById(Long employeeId);

    List<RestaurantEmployee> getAllRestaurantEmployees();

    void deleteRestaurantEmployeeById(Long employeeId);

    void updateRestaurantEmployee(RestaurantEmployee restaurantEmployee);
}
