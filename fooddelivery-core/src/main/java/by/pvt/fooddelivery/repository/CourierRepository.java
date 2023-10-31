package by.pvt.fooddelivery.repository;

import by.pvt.fooddelivery.domain.Courier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourierRepository extends JpaRepository<Courier, Long> {
}
