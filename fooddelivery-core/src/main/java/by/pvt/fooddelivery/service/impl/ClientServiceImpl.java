package by.pvt.fooddelivery.service.impl;

import by.pvt.fooddelivery.domain.Client;
import by.pvt.fooddelivery.dto.ClientRequest;
import by.pvt.fooddelivery.dto.ClientResponse;
import by.pvt.fooddelivery.exception.ApplicationException;
import by.pvt.fooddelivery.mapper.ClientMapper;
import by.pvt.fooddelivery.repository.ClientRepository;
import by.pvt.fooddelivery.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static by.pvt.fooddelivery.exception.ApplicationError.CLIENT_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    @Override
    @Transactional
    public ClientResponse register(ClientRequest clientRequest) {
        return clientMapper.toDTO(clientRepository.save(clientMapper.toClient(clientRequest)));
    }

    @Override
    public ClientResponse authorize(ClientRequest clientRequest) {
        Client client = clientRepository.findByEmail(clientRequest.getEmail()).orElseThrow(() -> new ApplicationException(CLIENT_NOT_FOUND));
        if (client.getPassword().equals(clientRequest.getPassword())) {
            return clientMapper.toDTO(client);
        } else {
            throw new ApplicationException(CLIENT_NOT_FOUND);
        }
    }

    @Override
    @Transactional
    public void deleteClientById(Long clientId) {
        clientRepository.delete(clientMapper.toClient(findClientById(clientId)));
    }

    @Override
    public ClientResponse findClientById(Long clientId) {
        return clientMapper.toDTO(clientRepository.findById(clientId).orElseThrow(() -> new ApplicationException(CLIENT_NOT_FOUND)));
    }

    @Override
    public List<ClientResponse> findAllClients() {
        List<ClientResponse> clients = clientRepository.findAll().stream().map(clientMapper::toDTO).toList();
        if (clients.isEmpty()) {
            throw new ApplicationException(CLIENT_NOT_FOUND);
        }
        return clients;
    }

    @Override
    @Transactional
    public ClientResponse updateClient(ClientRequest clientRequest) {
        return clientMapper.toDTO(clientRepository.save(clientMapper.toClient(clientRequest)));
    }
}
