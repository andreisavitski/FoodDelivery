package by.pvt.fooddelivery.service.impl;

import by.pvt.fooddelivery.domain.user.Admin;
import by.pvt.fooddelivery.repository.AdminRepository;
import by.pvt.fooddelivery.service.AdminApi;

import java.util.List;

public class AdminService implements AdminApi {
    private final AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public void addAdmin(Admin admin) {
        adminRepository.addAdmin(admin);
    }

    @Override
    public void deleteAdminById(Long adminId) {
        adminRepository.deleteAdminById(adminId);
    }

    @Override
    public Admin getAdminById(Long adminId) {
        return adminRepository.getAdminById(adminId).orElseThrow(() -> new RuntimeException("Admin does not exist"));
    }

    @Override
    public List<Admin> getAllAdmins() {
        return adminRepository.getAllAdmins();
    }

    @Override
    public void updateAdmin(Admin admin) {
        adminRepository.updateAdmin(admin);
    }
}
