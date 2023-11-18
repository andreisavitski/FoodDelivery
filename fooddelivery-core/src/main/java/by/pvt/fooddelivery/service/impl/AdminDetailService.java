package by.pvt.fooddelivery.service.impl;

import by.pvt.fooddelivery.exception.ApplicationException;
import by.pvt.fooddelivery.repository.AdminRepository;
import by.pvt.fooddelivery.security.AdminDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static by.pvt.fooddelivery.exception.ApplicationError.ADMIN_NOT_FOUND;

@Service
public class AdminDetailService implements UserDetailsService {
    @Autowired
    private AdminRepository adminRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return adminRepository.findByLogin(username).map(AdminDetails::new).orElseThrow(() -> new ApplicationException(ADMIN_NOT_FOUND));
    }
}
