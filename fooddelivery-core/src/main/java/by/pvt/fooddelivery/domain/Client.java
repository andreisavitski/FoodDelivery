package by.pvt.fooddelivery.domain;

import by.pvt.fooddelivery.enums.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import static by.pvt.fooddelivery.constant.AppConstants.SEQUENCE_GENERATOR;
import static jakarta.persistence.CascadeType.REMOVE;

@Getter
@Setter
@Entity
@Table(name = "client")
@SequenceGenerator(name = SEQUENCE_GENERATOR, sequenceName = "client_seq", allocationSize = 1)
public class Client extends AbstractEntity {
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
    @Embedded
    private Address address;
    @Column(name = "phone_number", unique = true)
    private String phoneNumber;
    @OneToMany(mappedBy = "client", cascade = REMOVE)
    private List<Order> orders;
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;
}
