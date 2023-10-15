package by.pvt.fooddelivery.service;

import by.pvt.fooddelivery.dto.AdminDTO;

import java.util.List;

public interface AdminApi {
    void registration(AdminDTO adminDTO);

    void deleteAdminById(Long adminId);

    AdminDTO getAdminById(Long adminId);

    List<AdminDTO> getAllAdmins();

    void updateAdmin(AdminDTO adminDTO);
}
