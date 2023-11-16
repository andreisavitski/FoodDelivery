package by.pvt.fooddelivery.repository;

import by.pvt.fooddelivery.domain.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}
