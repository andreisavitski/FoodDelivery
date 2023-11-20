package by.pvt.fooddelivery.api.controller;

import by.pvt.fooddelivery.dto.AdminDTO;
import by.pvt.fooddelivery.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminRestController {
    private final AdminService adminService;

    @GetMapping("/getAll")
    public List<AdminDTO> getAdmins() {
        return adminService.findAllAdmins();
    }


    @PostMapping("/addAdmin")
    public AdminDTO addAdmin(@RequestBody AdminDTO dto) {
        return adminService.registration(dto);
    }

    @GetMapping("/getAdmin/{id}")
    public AdminDTO getAdmin(@PathVariable("id") Long id) {
        return adminService.findAdminById(id);
    }

    @PutMapping("/updateAdmin")
    public AdminDTO updateAdmin(@RequestBody AdminDTO dto) {
        return adminService.updateAdmin(dto);
    }

    @DeleteMapping("/deleteAdmin/{id}")
    public void deleteAdmin(@PathVariable("id") Long id) {
        adminService.deleteAdminById(id);
    }
}
