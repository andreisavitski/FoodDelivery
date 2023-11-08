package by.pvt.fooddelivery.service.impl;

import by.pvt.fooddelivery.domain.Admin;
import by.pvt.fooddelivery.dto.AdminRequest;
import by.pvt.fooddelivery.dto.AdminResponse;
import by.pvt.fooddelivery.exception.ApplicationException;
import by.pvt.fooddelivery.mapper.AdminMapper;
import by.pvt.fooddelivery.repository.AdminRepository;
import by.pvt.fooddelivery.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static by.pvt.fooddelivery.exception.ApplicationError.ADMIN_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final AdminRepository adminRepository;
    private final AdminMapper adminMapper;

    @Override
    @Transactional
    public AdminResponse register(AdminRequest adminRequest) {
        return adminMapper.toDTO(adminRepository.save(adminMapper.toAdmin(adminRequest)));
    }

    @Override
    public AdminResponse authorize(AdminRequest adminRequest) {
        Admin admin = adminRepository.findByEmail(adminRequest.getEmail()).orElseThrow(() -> new ApplicationException(ADMIN_NOT_FOUND));
        if (admin.getPassword().equals(adminRequest.getPassword())) {
            return adminMapper.toDTO(admin);
        } else {
            throw new ApplicationException(ADMIN_NOT_FOUND);
        }
    }

    @Override
    @Transactional
    public void deleteAdminById(Long adminId) {
        adminRepository.delete(adminMapper.toAdmin(findAdminById(adminId)));
    }

    @Override
    public AdminResponse findAdminById(Long adminId) {
        return adminMapper.toDTO(adminRepository.findById(adminId).orElseThrow(() -> new ApplicationException(ADMIN_NOT_FOUND)));
    }

    @Override
    public List<AdminResponse> findAllAdmins() {
        List<AdminResponse> admins = adminRepository.findAll().stream().map(adminMapper::toDTO).toList();
        if (admins.isEmpty()) {
            throw new ApplicationException(ADMIN_NOT_FOUND);
        }
        return admins;
    }

    @Override
    @Transactional
    public AdminResponse updateAdmin(AdminRequest adminRequest) {
        return adminMapper.toDTO(adminRepository.save(adminMapper.toAdmin(adminRequest)));
    }
}
