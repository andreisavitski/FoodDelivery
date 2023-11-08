package by.pvt.fooddelivery.repository;

import by.pvt.fooddelivery.domain.Courier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CourierRepository extends JpaRepository<Courier, Long> {
    Optional<Courier> findByEmail(String email);
}
