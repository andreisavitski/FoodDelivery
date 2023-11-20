package by.pvt.fooddelivery.controller;

import by.pvt.fooddelivery.dto.AdminRequestDTO;
import by.pvt.fooddelivery.dto.AdminResponseDTO;
import by.pvt.fooddelivery.logging.MethodLogging;
import by.pvt.fooddelivery.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("admin")
@RequiredArgsConstructor
public class AdminRestController {
    private final AdminService adminService;

    @MethodLogging
    @GetMapping
    public List<AdminResponseDTO> getAdmins() {
        return adminService.findAllAdmins();
    }

    @MethodLogging
    @PostMapping("register")
    public ResponseEntity<AdminResponseDTO> addAdmin(@RequestBody @Validated AdminRequestDTO dto) {
        return new ResponseEntity<>(adminService.register(dto), CREATED);
    }

    @MethodLogging
    @GetMapping("{id}")
    public AdminResponseDTO getAdmin(@PathVariable("id") Long id) {
        return adminService.findAdminById(id);
    }

    @MethodLogging
    @PutMapping
    public AdminResponseDTO updateAdmin(@RequestBody @Validated AdminRequestDTO dto) {
        return adminService.updateAdmin(dto);
    }

    @MethodLogging
    @DeleteMapping("{id}")
    public void deleteAdmin(@PathVariable("id") Long id) {
        adminService.deleteAdminById(id);
    }
}
