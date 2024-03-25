package by.pvt.fooddelivery.entity;

import by.pvt.fooddelivery.enums.CourierStatus;
import by.pvt.fooddelivery.enums.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import static jakarta.persistence.CascadeType.REMOVE;
import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.FetchType.EAGER;

@Getter
@Setter
@Entity
@Table(name = "courier")
public class Courier extends AbstractEntity {

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

    @OneToMany(mappedBy = "courier", cascade = REMOVE, fetch = EAGER)
    private List<Order> orders;

    @Enumerated(STRING)
    @Column(name = "status")
    private CourierStatus status;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;
}
