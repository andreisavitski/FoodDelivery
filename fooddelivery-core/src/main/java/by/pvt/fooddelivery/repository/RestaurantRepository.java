package by.pvt.fooddelivery.repository;

import by.pvt.fooddelivery.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}
