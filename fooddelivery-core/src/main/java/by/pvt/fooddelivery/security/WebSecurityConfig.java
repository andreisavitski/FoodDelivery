package by.pvt.fooddelivery.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static by.pvt.fooddelivery.constant.AppConstants.*;
import static org.springframework.http.HttpMethod.*;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true)
public class WebSecurityConfig {
    @Bean
    public PasswordEncoder byCryptPasswordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .cors(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorize -> authorize

                        .requestMatchers("admin/**").hasAuthority(SUPER_ADMIN)

                        .requestMatchers(GET, "client/**").hasAnyAuthority(SUPER_ADMIN, ADMIN)
                        .requestMatchers(PUT, "client/**").hasAnyAuthority(SUPER_ADMIN, ADMIN)
                        .requestMatchers(DELETE, "client/**").hasAnyAuthority(SUPER_ADMIN, ADMIN)
                        .requestMatchers("client/register").permitAll()

                        .requestMatchers("courier/**").hasAnyAuthority(SUPER_ADMIN, ADMIN)

                        .requestMatchers(POST, "restaurant/**").hasAnyAuthority(SUPER_ADMIN, ADMIN)
                        .requestMatchers(DELETE, "restaurant/**").hasAnyAuthority(SUPER_ADMIN, ADMIN)
                        .requestMatchers(PUT, "restaurant/**").hasAnyAuthority(SUPER_ADMIN, ADMIN)
                        .requestMatchers(GET, "restaurant/**").permitAll()

                        .requestMatchers(POST, "product").hasAnyAuthority(SUPER_ADMIN, ADMIN)
                        .requestMatchers(DELETE, "product/**").hasAnyAuthority(SUPER_ADMIN, ADMIN)
                        .requestMatchers(PUT, "product/**").hasAnyAuthority(SUPER_ADMIN, ADMIN)
                        .requestMatchers(GET, "product/**").permitAll()
                        .requestMatchers(POST, "product/restaurant", "product/name", "product/type").permitAll()

                        .requestMatchers(DELETE, "order").hasAnyAuthority(SUPER_ADMIN, ADMIN)
                        .requestMatchers(DELETE, "order/product").hasAnyAuthority(SUPER_ADMIN, ADMIN, CLIENT)
                        .requestMatchers(PUT, "order").hasAnyAuthority(SUPER_ADMIN, ADMIN)
                        .requestMatchers(GET, "order").hasAnyAuthority(SUPER_ADMIN, ADMIN)
                        .requestMatchers(GET, "order/free").hasAnyAuthority(SUPER_ADMIN, ADMIN, COURIER)
                        .requestMatchers(GET, "order/checkout").hasAnyAuthority(SUPER_ADMIN, ADMIN, CLIENT)
                        .requestMatchers(POST, "order/select", "order/refusal", "order/complete").hasAnyAuthority(SUPER_ADMIN, ADMIN, COURIER)
                        .requestMatchers(POST, "order/product").hasAnyAuthority(SUPER_ADMIN, ADMIN, CLIENT)
                        .requestMatchers(POST, "order").hasAnyAuthority(SUPER_ADMIN, ADMIN, CLIENT)

                        .requestMatchers("/swagger-ui/**", "/javainuse-openapi/**").permitAll()

                        .anyRequest().permitAll())
                .formLogin(withDefaults())
                .httpBasic(withDefaults())
                .build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new CompositeUserDetailService();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(byCryptPasswordEncoder());
        return authenticationProvider;
    }
}
