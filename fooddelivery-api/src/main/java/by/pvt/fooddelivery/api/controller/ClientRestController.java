package by.pvt.fooddelivery.api.controller;

import by.pvt.fooddelivery.dto.ClientRequestDTO;
import by.pvt.fooddelivery.dto.ClientResponseDTO;
import by.pvt.fooddelivery.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientRestController {
    private final ClientService clientService;

    @GetMapping("/getAll")
    public List<ClientResponseDTO> getClients() {
        return clientService.findAllClients();
    }


    @PostMapping("/addClient")
    public ClientResponseDTO addClient(@RequestBody ClientRequestDTO dto) {
        return clientService.registration(dto);
    }

    @GetMapping("/getClient/{id}")
    public ClientResponseDTO getClient(@PathVariable("id") Long id) {
        return clientService.findClientById(id);
    }

    @PutMapping("/updateClient")
    public ClientResponseDTO updateClient(@RequestBody ClientRequestDTO dto) {
        return clientService.updateClient(dto);
    }

    @DeleteMapping("/deleteClient/{id}")
    public void deleteClient(@PathVariable("id") Long id) {
        clientService.deleteClientById(id);
    }
}
