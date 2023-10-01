package by.pvt.fooddelivery.service.impl;

import by.pvt.fooddelivery.domain.user.Client;
import by.pvt.fooddelivery.repository.ClientRepository;
import by.pvt.fooddelivery.service.ClientApi;

import java.util.List;

public class ClientService implements ClientApi {
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public void addClient(Client client) {
        clientRepository.addClient(client);
    }

    @Override
    public void deleteClientById(Long clientId) {
        clientRepository.deleteClientById(clientId);
    }

    @Override
    public Client getClientById(Long clientId) {
        return clientRepository.getClientById(clientId).orElseThrow(() -> new RuntimeException("Client does not exist"));
    }

    @Override
    public List<Client> getAllClients() {
        return clientRepository.getAllClients();
    }

    @Override
    public void updateClient(Client client) {
        clientRepository.updateClient(client);
    }
}
