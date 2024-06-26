package by.pvt.fooddelivery.repository;

import by.pvt.fooddelivery.entity.Courier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CourierRepository extends JpaRepository<Courier, Long> {
    Optional<Courier> findByLogin(String login);
}
