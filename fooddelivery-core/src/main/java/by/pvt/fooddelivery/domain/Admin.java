package by.pvt.fooddelivery.domain;

import by.pvt.fooddelivery.enums.Role;
import jakarta.persistence.*;
import lombok.*;

import static by.pvt.fooddelivery.constant.AppConstants.SEQUENCE_GENERATOR;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "admins")
@SequenceGenerator(name = SEQUENCE_GENERATOR, sequenceName = "admin_seq", allocationSize = 1)
public class Admin extends AbstractEntity {
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email", unique = true)
    private String email;
    @Column(name = "login", unique = true)
    private String login;
    @Column(name = "password")
    private String password;
    @Column(name = "phone_number", unique = true)
    private String phoneNumber;
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;
}
