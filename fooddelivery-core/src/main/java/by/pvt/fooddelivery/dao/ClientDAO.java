package by.pvt.fooddelivery.dao;

import by.pvt.fooddelivery.domain.user.Client;

import java.util.List;

public interface ClientDAO {
    void addClient(Client client);

    void deleteClientById(Long id);

    Client getClientById(Long id);

    List<Client> getAllClients();
}
