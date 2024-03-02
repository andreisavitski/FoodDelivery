package by.pvt.fooddelivery.security;

import org.springframework.security.core.GrantedAuthority;

import java.util.List;

public interface User {
    Long getId();

    String getLogin();

    String getPassword();

    List<GrantedAuthority> getRole();

    String getEmail();
}
