package by.pvt.fooddelivery.service.impl;

import by.pvt.fooddelivery.dto.AdminDTO;
import by.pvt.fooddelivery.mapper.AdminMapper;
import by.pvt.fooddelivery.repository.AdminRepository;
import by.pvt.fooddelivery.service.AdminApi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminService implements AdminApi {
    private final AdminRepository adminRepository;
    private final AdminMapper adminMapper;

    @Override
    public void registration(AdminDTO adminDTO) {
        adminRepository.addAdmin(adminMapper.toAdmin(adminDTO));
    }

    @Override
    public void deleteAdminById(Long adminId) {
        adminRepository.deleteAdminById(adminId);
    }

    @Override
    public AdminDTO getAdminById(Long adminId) {
        return adminMapper.toDTO(adminRepository.getAdminById(adminId).orElseThrow(
                () -> new RuntimeException("Admin does not exist")));
    }

    @Override
    public List<AdminDTO> getAllAdmins() {
        return adminRepository.getAllAdmins().stream().map(adminMapper::toDTO).toList();
    }

    @Override
    public void updateAdmin(AdminDTO adminDTO) {
        adminRepository.updateAdmin(adminMapper.toAdmin(adminDTO));
    }
}
