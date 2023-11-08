package by.pvt.fooddelivery.service;

import by.pvt.fooddelivery.dto.AdminRequest;
import by.pvt.fooddelivery.dto.AdminResponse;

import java.util.List;

public interface AdminService {
    AdminResponse register(AdminRequest adminRequest);

    AdminResponse authorize(AdminRequest adminRequest);

    void deleteAdminById(Long adminId);

    AdminResponse findAdminById(Long adminId);

    List<AdminResponse> findAllAdmins();

    AdminResponse updateAdmin(AdminRequest adminRequest);
}
