package by.pvt.fooddelivery.repository;

import by.pvt.fooddelivery.domain.Client;

import java.util.List;
import java.util.Optional;

public interface ClientRepository {
    void addClient(Client client);

    void deleteClientById(Long clientId);

    Optional<Client> getClientById(Long clientId);

    List<Client> getAllClients();

    void updateClient(Client client);
}
