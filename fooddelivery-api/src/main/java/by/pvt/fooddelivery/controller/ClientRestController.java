package by.pvt.fooddelivery.controller;

import by.pvt.fooddelivery.dto.ClientRequestDTO;
import by.pvt.fooddelivery.dto.ClientResponseDTO;
import by.pvt.fooddelivery.logging.MethodLogging;
import by.pvt.fooddelivery.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("client")
@RequiredArgsConstructor
public class ClientRestController {
    private final ClientService clientService;

    @MethodLogging
    @GetMapping
    public List<ClientResponseDTO> getClients() {
        return clientService.findAllClients();
    }

    @MethodLogging
    @PostMapping("register")
    public ClientResponseDTO addClient(@RequestBody @Validated ClientRequestDTO dto) {
        return clientService.register(dto);
    }

    @MethodLogging
    @GetMapping("{id}")
    public ClientResponseDTO getClient(@PathVariable("id") Long id) {
        return clientService.findClientById(id);
    }

    @MethodLogging
    @PutMapping
    public ClientResponseDTO updateClient(@RequestBody @Validated ClientRequestDTO dto) {
        return clientService.updateClient(dto);
    }


    @DeleteMapping("{id}")
    public void deleteClient(@PathVariable("id") Long id) {
        clientService.deleteClientById(id);
    }
}
