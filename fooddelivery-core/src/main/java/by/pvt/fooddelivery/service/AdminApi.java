package by.pvt.fooddelivery.service;

import by.pvt.fooddelivery.domain.user.Admin;

import java.util.List;

public interface AdminApi {
    void addAdmin(Admin admin);

    void deleteAdminById(Long id);

    Admin getAdminById(Long id);

    List<Admin> getAllAdmins();
}
