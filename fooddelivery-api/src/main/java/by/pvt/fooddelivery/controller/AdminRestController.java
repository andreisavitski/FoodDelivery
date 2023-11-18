package by.pvt.fooddelivery.controller;

import by.pvt.fooddelivery.dto.AdminRequest;
import by.pvt.fooddelivery.dto.AdminResponse;
import by.pvt.fooddelivery.logging.Logging;
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

    @Logging
    @GetMapping
    public List<AdminResponse> getAdmins() {
        return adminService.findAllAdmins();
    }

    @Logging
    @PostMapping("register")
    public ResponseEntity<AdminResponse> addAdmin(@RequestBody @Validated AdminRequest dto) {
        return new ResponseEntity<>(adminService.register(dto), CREATED);
    }

    @Logging
    @GetMapping("{id}")
    public AdminResponse getAdmin(@PathVariable("id") Long id) {
        return adminService.findAdminById(id);
    }

    @Logging
    @PutMapping
    public AdminResponse updateAdmin(@RequestBody @Validated AdminRequest dto) {
        return adminService.updateAdmin(dto);
    }

    @Logging
    @DeleteMapping("{id}")
    public void deleteAdmin(@PathVariable("id") Long id) {
        adminService.deleteAdminById(id);
    }
}
