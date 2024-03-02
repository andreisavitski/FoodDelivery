package by.pvt.fooddelivery.service.impl.security;

import by.pvt.fooddelivery.exception.ApplicationException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

import static by.pvt.fooddelivery.exception.ApplicationError.USER_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class CompositeUserDetailService implements UserDetailsService {
    private final List<UserDetailsService> services;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        for (UserDetailsService delegate : services)
            try {
                return delegate.loadUserByUsername(username);
            } catch (ApplicationException ignored) {
            }
        throw new ApplicationException(USER_NOT_FOUND);
    }
}
