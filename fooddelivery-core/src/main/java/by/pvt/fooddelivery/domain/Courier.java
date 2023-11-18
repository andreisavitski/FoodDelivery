package by.pvt.fooddelivery.domain;

import by.pvt.fooddelivery.enums.CourierStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import static by.pvt.fooddelivery.domain.AbstractEntity.SEQUENCE_GENERATOR;
import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.FetchType.EAGER;

@Getter
@Setter
@Entity
@Table(name = "courier")
@SequenceGenerator(name = SEQUENCE_GENERATOR, sequenceName = "courier_seq", allocationSize = 1)
public class Courier extends AbstractEntity {
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String login;
    private String password;
    @Column(name = "phone_number", unique = true)
    private String phoneNumber;
    @OneToMany(mappedBy = "courier", cascade = ALL, fetch = EAGER)
    private List<Order> orders;
    @Enumerated(STRING)
    private CourierStatus status;
    private String role;
}
