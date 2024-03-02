package by.pvt.fooddelivery.service;

import by.pvt.fooddelivery.dto.ClientRequestDTO;
import by.pvt.fooddelivery.dto.ClientResponseDTO;
import by.pvt.fooddelivery.dto.security.JwtAuthenticationResponseDTO;
import by.pvt.fooddelivery.dto.security.SignInRequestDTO;

import java.util.List;

public interface ClientService {
    JwtAuthenticationResponseDTO signUp(ClientRequestDTO clientRequestDTO);

    JwtAuthenticationResponseDTO signIn(SignInRequestDTO request);

    void deleteClientById(Long clientId);

    ClientResponseDTO findClientById(Long clientId);

    List<ClientResponseDTO> findAllClients();

    ClientResponseDTO updateClient(ClientRequestDTO clientRequestDTO);
}
