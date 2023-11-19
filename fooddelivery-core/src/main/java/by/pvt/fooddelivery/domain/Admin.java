package by.pvt.fooddelivery.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import static by.pvt.fooddelivery.domain.AbstractEntity.SEQUENCE_GENERATOR;

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
    @Column(name = "role")
    private String role;
}
