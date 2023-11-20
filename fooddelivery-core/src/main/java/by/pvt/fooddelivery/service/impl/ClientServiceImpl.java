package by.pvt.fooddelivery.service.impl;

import by.pvt.fooddelivery.domain.Client;
import by.pvt.fooddelivery.dto.ClientRequestDTO;
import by.pvt.fooddelivery.dto.ClientResponseDTO;
import by.pvt.fooddelivery.exception.ApplicationException;
import by.pvt.fooddelivery.mapper.ClientMapper;
import by.pvt.fooddelivery.repository.ClientRepository;
import by.pvt.fooddelivery.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static by.pvt.fooddelivery.constant.AppConstants.CLIENT;
import static by.pvt.fooddelivery.exception.ApplicationError.CLIENT_NOT_ADDED;
import static by.pvt.fooddelivery.exception.ApplicationError.CLIENT_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public ClientResponseDTO register(ClientRequestDTO clientRequestDTO) {
        Client client = clientMapper.toClient(clientRequestDTO);
        client.setPassword(passwordEncoder.encode(clientRequestDTO.getPassword()));
        client.setRole(CLIENT);
        return clientMapper.toDTO(clientRepository.save(checkingUniqueLoginAndPhoneNumber(client)));
    }

    @Override
    @Transactional
    public void deleteClientById(Long clientId) {
        clientRepository.delete(clientMapper.toClient(findClientById(clientId)));
    }

    @Override
    public ClientResponseDTO findClientById(Long clientId) {
        return clientMapper.toDTO(clientRepository.findById(clientId).orElseThrow(() -> new ApplicationException(CLIENT_NOT_FOUND)));
    }

    @Override
    public List<ClientResponseDTO> findAllClients() {
        List<ClientResponseDTO> clients = clientRepository.findAll().stream().map(clientMapper::toDTO).toList();
        if (clients.isEmpty()) {
            throw new ApplicationException(CLIENT_NOT_FOUND);
        }
        return clients;
    }

    @Override
    @Transactional
    public ClientResponseDTO updateClient(ClientRequestDTO clientRequestDTO) {
        findClientById(clientRequestDTO.getId());
        return clientMapper.toDTO(clientRepository.save(checkingUniqueLoginAndPhoneNumber(clientMapper.toClient(clientRequestDTO))));
    }

    private Client checkingUniqueLoginAndPhoneNumber(Client client) {
        if (!clientRepository.findAll().stream().filter(c -> c.getLogin().equals(client.getLogin())).filter(c -> c.getPhoneNumber().equals(client.getPhoneNumber())).toList().isEmpty()) {
            throw new ApplicationException(CLIENT_NOT_ADDED);
        }
        return client;
    }
}
