package by.pvt.fooddelivery.service;

import by.pvt.fooddelivery.dto.ClientRequestDTO;

import java.util.List;

public interface ClientService {
    void registration(ClientRequestDTO clientRequestDTO);

    void deleteClientById(Long clientId);

    ClientRequestDTO findClientById(Long clientId);

    List<ClientRequestDTO> findAllClients();

    void updateClient(ClientRequestDTO clientRequestDTO);
}
