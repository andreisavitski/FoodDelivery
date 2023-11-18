package by.pvt.fooddelivery.service;

import by.pvt.fooddelivery.dto.ClientRequest;
import by.pvt.fooddelivery.dto.ClientResponse;

import java.util.List;

public interface ClientService {
    ClientResponse register(ClientRequest clientRequest);

    void deleteClientById(Long clientId);

    ClientResponse findClientById(Long clientId);

    List<ClientResponse> findAllClients();

    ClientResponse updateClient(ClientRequest clientRequest);
}
