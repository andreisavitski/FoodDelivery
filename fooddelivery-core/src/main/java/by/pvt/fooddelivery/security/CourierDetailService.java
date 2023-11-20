package by.pvt.fooddelivery.security;

import by.pvt.fooddelivery.exception.ApplicationException;
import by.pvt.fooddelivery.repository.CourierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static by.pvt.fooddelivery.exception.ApplicationError.COURIER_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class CourierDetailService implements UserDetailsService {
    private final CourierRepository courierRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return courierRepository.findByLogin(username).map(CourierDetails::new).orElseThrow(() -> new ApplicationException(COURIER_NOT_FOUND));
    }
}
