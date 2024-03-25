package by.pvt.fooddelivery.service.impl;

import by.pvt.fooddelivery.entity.Client;
import by.pvt.fooddelivery.dto.ClientRequestDTO;
import by.pvt.fooddelivery.dto.ClientResponseDTO;
import by.pvt.fooddelivery.dto.security.JwtAuthenticationResponseDTO;
import by.pvt.fooddelivery.dto.security.SignInRequestDTO;
import by.pvt.fooddelivery.exception.ApplicationException;
import by.pvt.fooddelivery.mapper.ClientMapper;
import by.pvt.fooddelivery.repository.ClientRepository;
import by.pvt.fooddelivery.security.ClientDetails;
import by.pvt.fooddelivery.service.ClientService;
import by.pvt.fooddelivery.service.impl.security.CompositeUserDetailService;
import by.pvt.fooddelivery.service.impl.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static by.pvt.fooddelivery.enums.Role.CLIENT;
import static by.pvt.fooddelivery.exception.ApplicationError.CLIENT_NOT_ADDED;
import static by.pvt.fooddelivery.exception.ApplicationError.CLIENT_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final CompositeUserDetailService compositeUserDetailService;

    private final AuthenticationManager authenticationManager;

    private final ClientRepository clientRepository;

    private final ClientMapper clientMapper;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    @Override
    @Transactional
    public JwtAuthenticationResponseDTO signUp(ClientRequestDTO clientRequestDTO) {
        Client client = clientMapper.toClient(clientRequestDTO);
        client.setPassword(passwordEncoder.encode(clientRequestDTO.getPassword()));
        client.setRole(CLIENT);
        clientMapper.toDTO(clientRepository.save(checkingUniqueLoginAndPhoneNumber(client)));
        ClientDetails clientDetails = new ClientDetails(client);
        String jwt = jwtService.generateToken((clientDetails));
        return new JwtAuthenticationResponseDTO(jwt);
    }

    @Override
    public JwtAuthenticationResponseDTO signIn(SignInRequestDTO request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getLogin(), request.getPassword())
        );
        UserDetails client = compositeUserDetailService.loadUserByUsername(request.getLogin());
        String jwt = jwtService.generateToken(client);
        return new JwtAuthenticationResponseDTO(jwt);
    }

    @Override
    @Transactional
    public void deleteClientById(Long clientId) {
        clientRepository.delete(clientMapper.toClient(findClientById(clientId)));
    }

    @Override
    public ClientResponseDTO findClientById(Long clientId) {
        return clientMapper.toDTO(clientRepository.findById(clientId).orElseThrow(
                () -> new ApplicationException(CLIENT_NOT_FOUND)
        ));
    }

    @Override
    public List<ClientResponseDTO> findAllClients() {
        return clientRepository.findAll().stream()
                .map(clientMapper::toDTO)
                .toList();
    }

    @Override
    @Transactional
    public ClientResponseDTO updateClient(ClientRequestDTO clientRequestDTO) {
        findClientById(clientRequestDTO.getId());
        return clientMapper.toDTO(
                clientRepository.save(
                        checkingUniqueLoginAndPhoneNumber(
                                clientMapper.toClient(clientRequestDTO)
                        )
                )
        );
    }

    private Client checkingUniqueLoginAndPhoneNumber(Client client) {
        if (!clientRepository.findAll().stream()
                .filter(c -> c.getLogin().equals(client.getLogin()))
                .filter(c -> c.getPhoneNumber().equals(client.getPhoneNumber()))
                .toList()
                .isEmpty()) {
            throw new ApplicationException(CLIENT_NOT_ADDED);
        }
        return client;
    }
}
