package by.pvt.fooddelivery.service;

import by.pvt.fooddelivery.domain.Client;
import by.pvt.fooddelivery.dto.ClientDTO;

import java.util.List;

public interface ClientApi {
    void registration(ClientDTO clientDTO);

    void deleteClientById(Long clientId);

    ClientDTO getClientById(Long clientId);

    List<ClientDTO> getAllClients();

    void updateClient(ClientDTO clientDTO);
}
