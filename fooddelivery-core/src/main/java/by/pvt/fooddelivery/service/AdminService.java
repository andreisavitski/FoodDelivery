package by.pvt.fooddelivery.service;

import by.pvt.fooddelivery.dto.AdminRequestDTO;
import by.pvt.fooddelivery.dto.AdminResponseDTO;
import by.pvt.fooddelivery.dto.security.JwtAuthenticationResponseDTO;
import by.pvt.fooddelivery.dto.security.SignInRequestDTO;

import java.util.List;

public interface AdminService {
    JwtAuthenticationResponseDTO signUp(AdminRequestDTO adminRequestDTO);

    void deleteAdminById(Long adminId);

    AdminResponseDTO findAdminById(Long adminId);
    AdminResponseDTO findByLogin(String login);

    List<AdminResponseDTO> findAllAdmins();

    AdminResponseDTO updateAdmin(AdminRequestDTO adminRequestDTO);
    JwtAuthenticationResponseDTO signIn(SignInRequestDTO request);
}
