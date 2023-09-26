package by.pvt.fooddelivery.dao;

import by.pvt.fooddelivery.domain.user.Admin;

import java.util.List;

public interface AdminDAO {
    void addAdmin(Admin admin);

    void deleteAdminById(Long id);

    Admin getAdminById(Long id);

    List<Admin> getAllAdmins();
}
