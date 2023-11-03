package by.pvt.fooddelivery.service.impl;

import by.pvt.fooddelivery.dto.AdminDTO;
import by.pvt.fooddelivery.mapper.AdminMapper;
import by.pvt.fooddelivery.repository.AdminRepository;
import by.pvt.fooddelivery.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final AdminRepository adminRepository;
    private final AdminMapper adminMapper;

    @Override
    @Transactional
    public AdminDTO registration(AdminDTO adminDTO) {
        return adminMapper.toDTO(adminRepository.save(adminMapper.toAdmin(adminDTO)));
    }

    @Override
    @Transactional
    public void deleteAdminById(Long adminId) {
        adminRepository.deleteById(adminId);
    }

    @Override
    public AdminDTO findAdminById(Long adminId) {
        return adminMapper.toDTO(adminRepository.findById(adminId).orElseThrow(
                () -> new RuntimeException("Admin does not exist")));
    }

    @Override
    public List<AdminDTO> findAllAdmins() {
        return adminRepository.findAll().stream().map(adminMapper::toDTO).toList();
    }

    @Override
    @Transactional
    public AdminDTO updateAdmin(AdminDTO adminDTO) {
        return adminMapper.toDTO(adminRepository.save(adminMapper.toAdmin(adminDTO)));
    }
}
