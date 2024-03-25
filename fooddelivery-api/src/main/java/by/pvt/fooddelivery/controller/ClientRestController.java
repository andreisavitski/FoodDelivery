package by.pvt.fooddelivery.controller;

import by.pvt.fooddelivery.dto.ClientRequestDTO;
import by.pvt.fooddelivery.dto.ClientResponseDTO;
import by.pvt.fooddelivery.dto.security.JwtAuthenticationResponseDTO;
import by.pvt.fooddelivery.dto.security.SignInRequestDTO;
import by.pvt.fooddelivery.logging.MethodLogging;
import by.pvt.fooddelivery.service.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/client")
@RequiredArgsConstructor
@Tag(name = "CLIENT", description = "Allows you to manage clients")
public class ClientRestController {

    private final ClientService clientService;

    @Operation(summary = "Get all clients", security = @SecurityRequirement(name = "bearerAuth"))
    @MethodLogging
    @GetMapping
    public List<ClientResponseDTO> getClients() {
        return clientService.findAllClients();
    }

    @Operation(summary = "Get a client by ID", security = @SecurityRequirement(name = "bearerAuth"))
    @MethodLogging
    @GetMapping("/{id}")
    public ClientResponseDTO getClient(@PathVariable("id") Long id) {
        return clientService.findClientById(id);
    }

    @Operation(summary = "Change client", security = @SecurityRequirement(name = "bearerAuth"))
    @MethodLogging
    @PutMapping
    public ClientResponseDTO updateClient(@RequestBody @Validated ClientRequestDTO dto) {
        return clientService.updateClient(dto);
    }

    @Operation(summary = "Delete a client by ID", security = @SecurityRequirement(name = "bearerAuth"))
    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable("id") Long id) {
        clientService.deleteClientById(id);
    }

    @Operation(summary = "Client registration", security = @SecurityRequirement(name = "bearerAuth"))
    @PostMapping("/sign-up")
    public JwtAuthenticationResponseDTO signUp(@RequestBody @Valid ClientRequestDTO request) {
        return clientService.signUp(request);
    }

    @Operation(summary = "Client authorization", security = @SecurityRequirement(name = "bearerAuth"))
    @PostMapping("/sign-in")
    public JwtAuthenticationResponseDTO signIn(@RequestBody @Valid SignInRequestDTO request) {
        return clientService.signIn(request);
    }
}
