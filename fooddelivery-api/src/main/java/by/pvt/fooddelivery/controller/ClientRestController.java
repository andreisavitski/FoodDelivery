package by.pvt.fooddelivery.controller;

import by.pvt.fooddelivery.dto.ClientRequest;
import by.pvt.fooddelivery.dto.ClientResponse;
import by.pvt.fooddelivery.logging.Logging;
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

    @Logging
    @GetMapping
    public List<ClientResponse> getClients() {
        return clientService.findAllClients();
    }

    @Logging
    @PostMapping("register")
    public ClientResponse addClient(@RequestBody @Validated ClientRequest dto) {
        return clientService.register(dto);
    }

    @Logging
    @GetMapping("{id}")
    public ClientResponse getClient(@PathVariable("id") Long id) {
        return clientService.findClientById(id);
    }

    @Logging
    @PutMapping
    public ClientResponse updateClient(@RequestBody @Validated ClientRequest dto) {
        return clientService.updateClient(dto);
    }

    @Logging
    @DeleteMapping("{id}")
    public void deleteClient(@PathVariable("id") Long id) {
        clientService.deleteClientById(id);
    }
}
