package by.pvt.fooddelivery.service;

import by.pvt.fooddelivery.dto.AdminDTO;

import java.util.List;

public interface AdminService {
    AdminDTO registration(AdminDTO adminDTO);

    void deleteAdminById(Long adminId);

    AdminDTO findAdminById(Long adminId);

    List<AdminDTO> findAllAdmins();

    AdminDTO updateAdmin(AdminDTO adminDTO);
}
