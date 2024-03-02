package by.pvt.fooddelivery.service.impl.security;

import by.pvt.fooddelivery.exception.ApplicationException;
import by.pvt.fooddelivery.repository.AdminRepository;
import by.pvt.fooddelivery.security.AdminDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static by.pvt.fooddelivery.exception.ApplicationError.ADMIN_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class AdminDetailService implements UserDetailsService {
    private final AdminRepository adminRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return adminRepository.findByLogin(username).map(AdminDetails::new).orElseThrow(
                () -> new ApplicationException(ADMIN_NOT_FOUND)
        );
    }
}
