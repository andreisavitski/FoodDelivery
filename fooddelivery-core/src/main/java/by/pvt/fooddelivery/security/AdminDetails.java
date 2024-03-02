package by.pvt.fooddelivery.security;

import by.pvt.fooddelivery.domain.Admin;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class AdminDetails implements UserDetails, User {
    private final Long id;
    private final String username;
    private final String password;
    private final String email;
    private final List<GrantedAuthority> authorities;

    public AdminDetails(Admin admin) {
        this.id = admin.getId();
        this.username = admin.getLogin();
        this.password = admin.getPassword();
        this.email = admin.getEmail();
        this.authorities = Arrays.stream(admin.getRole().toString().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getLogin() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public List<GrantedAuthority> getRole() {
        return authorities;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
