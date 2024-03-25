package by.pvt.fooddelivery.service.impl;

import by.pvt.fooddelivery.entity.Admin;
import by.pvt.fooddelivery.dto.AdminRequestDTO;
import by.pvt.fooddelivery.dto.AdminResponseDTO;
import by.pvt.fooddelivery.dto.security.JwtAuthenticationResponseDTO;
import by.pvt.fooddelivery.dto.security.SignInRequestDTO;
import by.pvt.fooddelivery.exception.ApplicationException;
import by.pvt.fooddelivery.mapper.AdminMapper;
import by.pvt.fooddelivery.repository.AdminRepository;
import by.pvt.fooddelivery.security.AdminDetails;
import by.pvt.fooddelivery.service.AdminService;
import by.pvt.fooddelivery.service.impl.security.CompositeUserDetailService;
import by.pvt.fooddelivery.service.impl.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static by.pvt.fooddelivery.enums.Role.ADMIN;
import static by.pvt.fooddelivery.exception.ApplicationError.ADMIN_NOT_ADDED;
import static by.pvt.fooddelivery.exception.ApplicationError.ADMIN_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final CompositeUserDetailService compositeUserDetailService;

    private final AdminRepository adminRepository;

    private final AdminMapper adminMapper;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    @Override
    @Transactional
    public JwtAuthenticationResponseDTO signUp(AdminRequestDTO adminRequestDTO) {
        Admin admin = adminMapper.toAdmin(adminRequestDTO);
        admin.setPassword(passwordEncoder.encode(adminRequestDTO.getPassword()));
        admin.setRole(ADMIN);
        adminMapper.toDTO(adminRepository.save(checkingUniqueLoginAndPhoneNumber(admin)));
        AdminDetails adminDetails = new AdminDetails(admin);
        String jwt = jwtService.generateToken((adminDetails));
        return new JwtAuthenticationResponseDTO(jwt);
    }

    @Override
    @Transactional
    public void deleteAdminById(Long adminId) {
        adminRepository.delete(adminMapper.toAdmin(findAdminById(adminId)));
    }

    @Override
    public AdminResponseDTO findAdminById(Long adminId) {
        return adminMapper.toDTO(adminRepository.findById(adminId).orElseThrow(
                () -> new ApplicationException(ADMIN_NOT_FOUND)
        ));
    }

    @Override
    public AdminResponseDTO findByLogin(String login) {
        return adminMapper.toDTO(adminRepository.findByLogin(login).orElseThrow(
                () -> new ApplicationException(ADMIN_NOT_FOUND)
        ));
    }

    @Override
    public List<AdminResponseDTO> findAllAdmins() {
        return adminRepository.findAll().stream()
                .map(adminMapper::toDTO)
                .toList();
    }

    @Override
    @Transactional
    public AdminResponseDTO updateAdmin(AdminRequestDTO adminRequestDTO) {
        findAdminById(adminRequestDTO.getId());
        return adminMapper.toDTO(
                adminRepository.save(
                        checkingUniqueLoginAndPhoneNumber(
                                adminMapper.toAdmin(adminRequestDTO)
                        )
                )
        );
    }

    private Admin checkingUniqueLoginAndPhoneNumber(Admin admin) {
        if (!adminRepository.findAll().stream()
                .filter(a -> a.getLogin().equals(admin.getLogin()))
                .filter(a -> a.getPhoneNumber().equals(admin.getPhoneNumber()))
                .toList()
                .isEmpty()) {
            throw new ApplicationException(ADMIN_NOT_ADDED);
        }
        return admin;
    }

    @Override
    public JwtAuthenticationResponseDTO signIn(SignInRequestDTO request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getLogin(), request.getPassword())
        );
        UserDetails admin = compositeUserDetailService.loadUserByUsername(request.getLogin());
        String jwt = jwtService.generateToken(admin);
        return new JwtAuthenticationResponseDTO(jwt);
    }
}
