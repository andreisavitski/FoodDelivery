package by.pvt.fooddelivery.service;

import by.pvt.fooddelivery.domain.user.RestaurantEmployee;

import java.util.List;

public interface RestaurantEmployeeApi {
    void addRestaurantEmployee(RestaurantEmployee restaurantEmployee);

    RestaurantEmployee getRestaurantEmployeeById(Long employeeId);

    List<RestaurantEmployee> getAllRestaurantEmployees();

    void deleteRestaurantEmployeeById(Long employeeId);

    void updateRestaurantEmployee(RestaurantEmployee restaurantEmployee);

}
