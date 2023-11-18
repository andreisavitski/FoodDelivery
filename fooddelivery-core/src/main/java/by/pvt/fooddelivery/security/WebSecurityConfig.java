package by.pvt.fooddelivery.security;

import by.pvt.fooddelivery.service.impl.CompositeUserDetailService;
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
//                        .requestMatchers("admin").hasAuthority(SUPER_ADMIN)
//                        .requestMatchers("client").hasAnyAuthority(SUPER_ADMIN, ADMIN)
//                        .requestMatchers("client/register").permitAll()
//                        .requestMatchers("courier").hasAnyAuthority(SUPER_ADMIN, ADMIN)
//                        .requestMatchers("restaurant").hasAnyAuthority(SUPER_ADMIN, ADMIN)
//                        .requestMatchers(GET, "restaurant").permitAll()
//                        .requestMatchers("product").hasAnyAuthority(SUPER_ADMIN, ADMIN)
//                        .requestMatchers(GET, "product").hasAnyAuthority(CLIENT, COURIER)
//                        .requestMatchers("product/restaurant", "product/name", "product/type").hasAnyAuthority(CLIENT, COURIER)
//                        .requestMatchers("order").hasAnyAuthority(SUPER_ADMIN, ADMIN)
//                        .requestMatchers("order/select", "order/refusal", "order/complete", "order/free").hasAuthority(COURIER)
//                        .requestMatchers("order/product").hasAuthority(CLIENT)
//                        .anyRequest().authenticated())
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
