package by.pvt.fooddelivery.repository;

import by.pvt.fooddelivery.domain.Admin;

import java.util.List;
import java.util.Optional;

public interface AdminRepository {
    void addAdmin(Admin admin);

    void deleteAdminById(Long adminId);

    Optional<Admin> getAdminById(Long adminId);

    List<Admin> getAllAdmins();

    void updateAdmin(Admin admin);
}
