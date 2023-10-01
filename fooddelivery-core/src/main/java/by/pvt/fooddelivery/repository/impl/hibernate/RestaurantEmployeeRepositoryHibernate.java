package by.pvt.fooddelivery.repository.impl.hibernate;

import by.pvt.fooddelivery.domain.user.RestaurantEmployee;
import by.pvt.fooddelivery.repository.RestaurantEmployeeRepository;

import java.util.List;
import java.util.Optional;

public class RestaurantEmployeeRepositoryHibernate extends RepositoryCRUD implements RestaurantEmployeeRepository {

    @Override
    public void addRestaurantEmployee(RestaurantEmployee restaurantEmployee) {
        add(restaurantEmployee);
    }

    @Override
    public Optional<RestaurantEmployee> getRestaurantEmployeeById(Long employeeId) {
        return getById(RestaurantEmployee.class, employeeId);
    }

    @Override
    public List<RestaurantEmployee> getAllRestaurantEmployees() {
        return getAll(RestaurantEmployee.class);
    }

    @Override
    public void deleteRestaurantEmployeeById(Long employeeId) {
        deleteById(RestaurantEmployee.class, employeeId);
    }

    @Override
    public void updateRestaurantEmployee(RestaurantEmployee restaurantEmployee) {
        update(restaurantEmployee);
    }
}
