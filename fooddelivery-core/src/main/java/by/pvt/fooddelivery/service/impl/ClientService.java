package by.pvt.fooddelivery.service.impl;

import by.pvt.fooddelivery.dto.ClientDTO;
import by.pvt.fooddelivery.mapper.ClientMapper;
import by.pvt.fooddelivery.repository.ClientRepository;
import by.pvt.fooddelivery.service.ClientApi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClientService implements ClientApi {
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    @Override
    public void registration(ClientDTO clientDTO) {
        clientRepository.addClient(clientMapper.toClient(clientDTO));
    }

    @Override
    public void deleteClientById(Long clientId) {
        clientRepository.deleteClientById(clientId);
    }

    @Override
    public ClientDTO getClientById(Long clientId) {
        return clientMapper.toDTO(clientRepository.getClientById(clientId).orElseThrow(
                () -> new RuntimeException("Client does not exist")));
    }

    @Override
    public List<ClientDTO> getAllClients() {
        return clientRepository.getAllClients().stream().map(clientMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public void updateClient(ClientDTO clientDTO) {
        clientRepository.updateClient(clientMapper.toClient(clientDTO));
    }
}
