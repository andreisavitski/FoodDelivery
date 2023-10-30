package by.pvt.fooddelivery.service;

import by.pvt.fooddelivery.dto.AdminDTO;

import java.util.List;

public interface AdminService {
    void registration(AdminDTO adminDTO);

    void deleteAdminById(Long adminId);

    AdminDTO findAdminById(Long adminId);

    List<AdminDTO> findAllAdmins();

    void updateAdmin(AdminDTO adminDTO);
}
