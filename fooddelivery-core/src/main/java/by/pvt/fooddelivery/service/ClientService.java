package by.pvt.fooddelivery.service;

import by.pvt.fooddelivery.dto.ClientRequestDTO;
import by.pvt.fooddelivery.dto.ClientResponseDTO;

import java.util.List;

public interface ClientService {
    ClientResponseDTO registration(ClientRequestDTO clientRequestDTO);

    void deleteClientById(Long clientId);

    ClientResponseDTO findClientById(Long clientId);

    List<ClientResponseDTO> findAllClients();

    ClientResponseDTO updateClient(ClientRequestDTO clientRequestDTO);
}
