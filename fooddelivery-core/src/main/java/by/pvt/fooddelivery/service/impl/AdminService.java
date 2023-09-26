package by.pvt.fooddelivery.service.impl;

import by.pvt.fooddelivery.dao.AdminDAO;
import by.pvt.fooddelivery.domain.user.Admin;
import by.pvt.fooddelivery.service.AdminApi;

import java.util.List;

public class AdminService implements AdminApi {
    private final AdminDAO adminDAO;

    public AdminService(AdminDAO adminDAO) {
        this.adminDAO = adminDAO;
    }

    @Override
    public void addAdmin(Admin admin) {
        adminDAO.addAdmin(admin);
    }

    @Override
    public void deleteAdminById(Long id) {
        adminDAO.deleteAdminById(id);
    }

    @Override
    public Admin getAdminById(Long id) {
        return adminDAO.getAdminById(id);
    }

    @Override
    public List<Admin> getAllAdmins() {
        return adminDAO.getAllAdmins();
    }
}
