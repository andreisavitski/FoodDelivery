package by.pvt.fooddelivery.controller;

import by.pvt.fooddelivery.dto.AdminRequestDTO;
import by.pvt.fooddelivery.dto.AdminResponseDTO;
import by.pvt.fooddelivery.dto.security.JwtAuthenticationResponseDTO;
import by.pvt.fooddelivery.dto.security.SignInRequestDTO;
import by.pvt.fooddelivery.service.AdminService;
import by.pvt.loggingaspect.MethodLogging;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
@RequiredArgsConstructor
@Tag(name = "ADMIN", description = "Allows you to manage administrators")
public class AdminRestController {

    private final AdminService adminService;

    @Operation(summary = "Get all administrators", security = @SecurityRequirement(name = "bearerAuth"))
    @MethodLogging
    @GetMapping
    public List<AdminResponseDTO> getAdmins() {
        return adminService.findAllAdmins();
    }

    @Operation(summary = "Get an administrator by ID", security = @SecurityRequirement(name = "bearerAuth"))
    @MethodLogging
    @GetMapping("/{id}")
    public AdminResponseDTO getAdmin(@PathVariable("id") Long id) {
        return adminService.findAdminById(id);
    }

    @Operation(summary = "Change administrator", security = @SecurityRequirement(name = "bearerAuth"))
    @MethodLogging
    @PutMapping
    public AdminResponseDTO updateAdmin(@RequestBody @Validated AdminRequestDTO dto) {
        return adminService.updateAdmin(dto);
    }

    @Operation(summary = "Delete an administrator by ID", security = @SecurityRequirement(name = "bearerAuth"))
    @DeleteMapping("/{id}")
    public void deleteAdmin(@PathVariable("id") Long id) {
        adminService.deleteAdminById(id);
    }

    @Operation(summary = "Administrator registration", security = @SecurityRequirement(name = "bearerAuth"))
    @MethodLogging
    @PostMapping("/sign-up")
    public JwtAuthenticationResponseDTO signUp(@RequestBody @Valid AdminRequestDTO request) {
        return adminService.signUp(request);
    }

    @Operation(summary = "Administrator authorization", security = @SecurityRequirement(name = "bearerAuth"))
    @MethodLogging
    @PostMapping("/sign-in")
    public JwtAuthenticationResponseDTO signIn(@RequestBody @Valid SignInRequestDTO request) {
        return adminService.signIn(request);
    }
}
