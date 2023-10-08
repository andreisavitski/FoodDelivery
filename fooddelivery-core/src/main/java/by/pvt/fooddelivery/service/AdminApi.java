package by.pvt.fooddelivery.service;

import by.pvt.fooddelivery.domain.user.Admin;

import java.util.List;

public interface AdminApi {
    void register(Admin admin);

    void deleteAdminById(Long adminId);

    Admin getAdminById(Long adminId);

    List<Admin> getAllAdmins();

    void updateAdmin(Admin admin);
}
