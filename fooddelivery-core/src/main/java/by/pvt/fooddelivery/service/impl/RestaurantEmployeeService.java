package by.pvt.fooddelivery.service.impl;

import by.pvt.fooddelivery.domain.user.RestaurantEmployee;
import by.pvt.fooddelivery.repository.RestaurantEmployeeRepository;
import by.pvt.fooddelivery.service.RestaurantEmployeeApi;

import java.util.List;

public class RestaurantEmployeeService implements RestaurantEmployeeApi {
    private final RestaurantEmployeeRepository restaurantEmployeeRepository;

    public RestaurantEmployeeService(RestaurantEmployeeRepository restaurantEmployeeRepository) {
        this.restaurantEmployeeRepository = restaurantEmployeeRepository;
    }

    @Override
    public void addRestaurantEmployee(RestaurantEmployee restaurantEmployee) {
        restaurantEmployeeRepository.addRestaurantEmployee(restaurantEmployee);

    }

    @Override
    public RestaurantEmployee getRestaurantEmployeeById(Long employeeId) {
        return restaurantEmployeeRepository.getRestaurantEmployeeById(employeeId).orElseThrow(
                () -> new RuntimeException("Restaurant employee does not exist"));
    }

    @Override
    public List<RestaurantEmployee> getAllRestaurantEmployees() {
        return restaurantEmployeeRepository.getAllRestaurantEmployees();
    }

    @Override
    public void deleteRestaurantEmployeeById(Long employeeId) {
        restaurantEmployeeRepository.deleteRestaurantEmployeeById(employeeId);
    }

    @Override
    public void updateRestaurantEmployee(RestaurantEmployee restaurantEmployee) {
        restaurantEmployeeRepository.updateRestaurantEmployee(restaurantEmployee);
    }
}
