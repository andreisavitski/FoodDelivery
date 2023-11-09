package by.pvt.fooddelivery.repository;

import by.pvt.fooddelivery.domain.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    Optional<Restaurant> findByName(String restaurantName);
}
