package by.pvt.fooddelivery.service.impl;

import by.pvt.fooddelivery.domain.Admin;
import by.pvt.fooddelivery.dto.AdminRequestDTO;
import by.pvt.fooddelivery.dto.AdminResponseDTO;
import by.pvt.fooddelivery.exception.ApplicationException;
import by.pvt.fooddelivery.mapper.AdminMapper;
import by.pvt.fooddelivery.repository.AdminRepository;
import by.pvt.fooddelivery.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static by.pvt.fooddelivery.constant.AppConstants.ADMIN;
import static by.pvt.fooddelivery.exception.ApplicationError.ADMIN_NOT_ADDED;
import static by.pvt.fooddelivery.exception.ApplicationError.ADMIN_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final AdminRepository adminRepository;
    private final AdminMapper adminMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public AdminResponseDTO register(AdminRequestDTO adminRequestDTO) {
        Admin admin = adminMapper.toAdmin(adminRequestDTO);
        admin.setPassword(passwordEncoder.encode(adminRequestDTO.getPassword()));
        admin.setRole(ADMIN);
        return adminMapper.toDTO(adminRepository.save(checkingUniqueLoginAndPhoneNumber(admin)));
    }

    @Override
    @Transactional
    public void deleteAdminById(Long adminId) {
        adminRepository.delete(adminMapper.toAdmin(findAdminById(adminId)));
    }

    @Override
    public AdminResponseDTO findAdminById(Long adminId) {
        return adminMapper.toDTO(adminRepository.findById(adminId).orElseThrow(() -> new ApplicationException(ADMIN_NOT_FOUND)));
    }

    @Override
    public List<AdminResponseDTO> findAllAdmins() {
        List<AdminResponseDTO> admins = adminRepository.findAll().stream().map(adminMapper::toDTO).toList();
        if (admins.isEmpty()) {
            throw new ApplicationException(ADMIN_NOT_FOUND);
        }
        return admins;
    }

    @Override
    @Transactional
    public AdminResponseDTO updateAdmin(AdminRequestDTO adminRequestDTO) {
        findAdminById(adminRequestDTO.getId());
        return adminMapper.toDTO(adminRepository.save(checkingUniqueLoginAndPhoneNumber(adminMapper.toAdmin(adminRequestDTO))));
    }

    private Admin checkingUniqueLoginAndPhoneNumber(Admin admin) {
        if (!adminRepository.findAll().stream().filter(a -> a.getLogin().equals(admin.getLogin())).filter(a -> a.getPhoneNumber().equals(admin.getPhoneNumber())).toList().isEmpty()) {
            throw new ApplicationException(ADMIN_NOT_ADDED);
        }
        return admin;
    }
}
