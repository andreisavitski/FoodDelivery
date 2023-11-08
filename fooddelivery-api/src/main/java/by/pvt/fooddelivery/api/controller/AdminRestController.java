package by.pvt.fooddelivery.api.controller;

import by.pvt.fooddelivery.dto.AdminRequest;
import by.pvt.fooddelivery.dto.AdminResponse;
import by.pvt.fooddelivery.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("admin")
@RequiredArgsConstructor
public class AdminRestController {
    private final AdminService adminService;

    @GetMapping
    public List<AdminResponse> getAdmins() {
        return adminService.findAllAdmins();
    }

    @PostMapping("register")
    public AdminResponse addAdmin(@RequestBody AdminRequest dto) {
        return adminService.register(dto);
    }

    @GetMapping("{id}")
    public AdminResponse getAdmin(@PathVariable("id") Long id) {
        return adminService.findAdminById(id);
    }

    @PutMapping
    public AdminResponse updateAdmin(@RequestBody AdminRequest dto) {
        return adminService.updateAdmin(dto);
    }

    @DeleteMapping("{id}")
    public void deleteAdmin(@PathVariable("id") Long id) {
        adminService.deleteAdminById(id);
    }
}
