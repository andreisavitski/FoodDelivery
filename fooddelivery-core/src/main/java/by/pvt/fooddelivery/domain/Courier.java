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
}
