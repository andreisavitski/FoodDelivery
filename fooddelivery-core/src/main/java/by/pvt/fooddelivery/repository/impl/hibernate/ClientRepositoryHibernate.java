package by.pvt.fooddelivery.repository.impl.hibernate;

import by.pvt.fooddelivery.domain.user.Client;
import by.pvt.fooddelivery.repository.ClientRepository;

import java.util.List;
import java.util.Optional;

public class ClientRepositoryHibernate extends RepositoryCRUD implements ClientRepository {

    @Override
    public void addClient(Client client) {
        add(client);
    }

    @Override
    public void deleteClientById(Long clientId) {
        deleteById(Client.class, clientId);
    }

    @Override
    public Optional<Client> getClientById(Long clientId) {
        return getById(Client.class, clientId);
    }

    @Override
    public List<Client> getAllClients() {
        return getAll(Client.class);
    }

    @Override
    public void updateClient(Client client) {
        update(client);
    }
}
