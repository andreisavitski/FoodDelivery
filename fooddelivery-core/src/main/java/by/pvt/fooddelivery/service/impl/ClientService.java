package by.pvt.fooddelivery.service.impl;

import by.pvt.fooddelivery.dao.ClientDAO;
import by.pvt.fooddelivery.domain.user.Client;
import by.pvt.fooddelivery.service.ClientApi;

import java.util.List;

public class ClientService implements ClientApi {
    private final ClientDAO clientDAO;

    public ClientService(ClientDAO clientDAO) {
        this.clientDAO = clientDAO;
    }

    @Override
    public void addClient(Client client) {
        clientDAO.addClient(client);
    }

    @Override
    public void deleteClientById(Long id) {
        clientDAO.deleteClientById(id);
    }

    @Override
    public Client getClientById(Long id) {
        return clientDAO.getClientById(id);
    }

    @Override
    public List<Client> getAllClients() {
        return clientDAO.getAllClients();
    }
}
