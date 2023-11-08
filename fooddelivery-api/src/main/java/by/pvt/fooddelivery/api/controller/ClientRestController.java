package by.pvt.fooddelivery.api.controller;

import by.pvt.fooddelivery.dto.ClientRequest;
import by.pvt.fooddelivery.dto.ClientResponse;
import by.pvt.fooddelivery.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("client")
@RequiredArgsConstructor
public class ClientRestController {
    private final ClientService clientService;

    @GetMapping
    public List<ClientResponse> getClients() {
        return clientService.findAllClients();
    }
    @PostMapping("register")
    public ClientResponse addClient(@RequestBody ClientRequest dto) {
        return clientService.register(dto);
    }

    @GetMapping("{id}")
    public ClientResponse getClient(@PathVariable("id") Long id) {
        return clientService.findClientById(id);
    }

    @PutMapping
    public ClientResponse updateClient(@RequestBody ClientRequest dto) {
        return clientService.updateClient(dto);
    }

    @DeleteMapping("{id}")
    public void deleteClient(@PathVariable("id") Long id) {
        clientService.deleteClientById(id);
    }
}
