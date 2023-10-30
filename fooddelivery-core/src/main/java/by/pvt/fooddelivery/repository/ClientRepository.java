package by.pvt.fooddelivery.repository;

import by.pvt.fooddelivery.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
