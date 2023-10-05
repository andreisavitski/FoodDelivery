package by.pvt.fooddelivery.service;

import by.pvt.fooddelivery.domain.user.Client;

import java.util.List;

public interface ClientApi {
    void addClient(Client client);

    void deleteClientById(Long clientId);

    Client getClientById(Long clientId);

    List<Client> getAllClients();

    void updateClient(Client client);
}