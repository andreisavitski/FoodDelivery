package by.pvt.fooddelivery.service.impl;

import by.pvt.fooddelivery.dto.ClientRequestDTO;
import by.pvt.fooddelivery.dto.ClientResponseDTO;
import by.pvt.fooddelivery.mapper.ClientMapper;
import by.pvt.fooddelivery.repository.ClientRepository;
import by.pvt.fooddelivery.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    @Override
    @Transactional
    public ClientResponseDTO registration(ClientRequestDTO clientRequestDTO) {
        return clientMapper.toDTO(clientRepository.save(clientMapper.toClient(clientRequestDTO)));
    }

    @Override
    @Transactional
    public void deleteClientById(Long clientId) {
        clientRepository.deleteById(clientId);
    }

    @Override
    public ClientResponseDTO findClientById(Long clientId) {
        return clientMapper.toDTO(clientRepository.findById(clientId).orElseThrow(
                () -> new RuntimeException("Client does not exist")));
    }

    @Override
    public List<ClientResponseDTO> findAllClients() {
        return clientRepository.findAll().stream().map(clientMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public ClientResponseDTO updateClient(ClientRequestDTO clientRequestDTO) {
        return clientMapper.toDTO(clientRepository.save(clientMapper.toClient(clientRequestDTO)));
    }
}
