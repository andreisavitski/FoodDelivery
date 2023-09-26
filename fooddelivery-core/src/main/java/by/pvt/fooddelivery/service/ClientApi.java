package by.pvt.fooddelivery.service;

import by.pvt.fooddelivery.domain.user.Client;

import java.util.List;

public interface ClientApi {
    void addClient(Client client);

    void deleteClientById(Long id);

    Client getClientById(Long id);

    List<Client> getAllClients();
}
