package by.pvt.fooddelivery.security;

import by.pvt.fooddelivery.exception.ApplicationException;
import by.pvt.fooddelivery.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static by.pvt.fooddelivery.exception.ApplicationError.CLIENT_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class ClientDetailService implements UserDetailsService {
    private final ClientRepository clientRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return clientRepository.findByLogin(username).map(ClientDetails::new).orElseThrow(() -> new ApplicationException(CLIENT_NOT_FOUND));
    }
}
