package by.pvt.fooddelivery.controller;

import by.pvt.fooddelivery.dto.CourierRequestDTO;
import by.pvt.fooddelivery.dto.CourierResponseDTO;
import by.pvt.fooddelivery.dto.security.JwtAuthenticationResponseDTO;
import by.pvt.fooddelivery.dto.security.SignInRequestDTO;
import by.pvt.fooddelivery.logging.MethodLogging;
import by.pvt.fooddelivery.service.CourierService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/courier")
@RequiredArgsConstructor
@Tag(name = "COURIER", description = "Allows you to manage couriers")
public class CourierRestController {

    private final CourierService courierService;

    @Operation(summary = "Get all couriers", security = @SecurityRequirement(name = "bearerAuth"))
    @MethodLogging
    @GetMapping
    public List<CourierResponseDTO> getClients() {
        return courierService.findAllCouriers();
    }

    @Operation(summary = "Get a courier by ID", security = @SecurityRequirement(name = "bearerAuth"))
    @MethodLogging
    @GetMapping("/{id}")
    public CourierResponseDTO getCourier(@PathVariable("id") Long id) {
        return courierService.findCourierById(id);
    }

    @Operation(summary = "Change client", security = @SecurityRequirement(name = "bearerAuth"))
    @MethodLogging
    @PutMapping
    public CourierResponseDTO updateCourier(@RequestBody @Validated CourierRequestDTO dto) {
        return courierService.updateCourier(dto);
    }

    @Operation(summary = "Delete a courier by ID", security = @SecurityRequirement(name = "bearerAuth"))
    @DeleteMapping("/{id}")
    public void deleteCourier(@PathVariable("id") Long id) {
        courierService.deleteCourierById(id);
    }

    @Operation(summary = "Courier registration", security = @SecurityRequirement(name = "bearerAuth"))
    @PostMapping("/sign-up")
    public JwtAuthenticationResponseDTO signUp(@RequestBody @Valid CourierRequestDTO request) {
        return courierService.signUp(request);
    }

    @Operation(summary = "Courier authorization", security = @SecurityRequirement(name = "bearerAuth"))
    @PostMapping("/sign-in")
    public JwtAuthenticationResponseDTO signIn(@RequestBody @Valid SignInRequestDTO request) {
        return courierService.signIn(request);
    }
}
