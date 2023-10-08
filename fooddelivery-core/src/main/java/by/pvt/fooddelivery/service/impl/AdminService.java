package by.pvt.fooddelivery.service.impl;

import by.pvt.fooddelivery.domain.user.Admin;
import by.pvt.fooddelivery.repository.AdminRepository;
import by.pvt.fooddelivery.service.AdminApi;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdminService implements AdminApi {
    private final AdminRepository adminRepository;
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public void register(Admin admin) {
        if (validate(admin.getEmail())){
            adminRepository.addAdmin(admin);
        }
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

    private static boolean validate(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr.toUpperCase());
        return matcher.matches();
    }
}
