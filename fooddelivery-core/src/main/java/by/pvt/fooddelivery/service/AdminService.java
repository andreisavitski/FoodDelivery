package by.pvt.fooddelivery.service;

import by.pvt.fooddelivery.dto.AdminRequestDTO;
import by.pvt.fooddelivery.dto.AdminResponseDTO;

import java.util.List;

public interface AdminService {
    AdminResponseDTO register(AdminRequestDTO adminRequestDTO);

    void deleteAdminById(Long adminId);

    AdminResponseDTO findAdminById(Long adminId);

    List<AdminResponseDTO> findAllAdmins();

    AdminResponseDTO updateAdmin(AdminRequestDTO adminRequestDTO);
}
