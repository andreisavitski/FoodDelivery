package by.pvt.fooddelivery.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

import static by.pvt.fooddelivery.domain.AbstractEntity.SEQUENCE_GENERATOR;
import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.CascadeType.REMOVE;
import static org.hibernate.annotations.OnDeleteAction.*;
import static org.hibernate.annotations.OnDeleteAction.CASCADE;

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
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String login;
    private String password;
    @Embedded
    private Address address;
    @Column(name = "phone_number", unique = true)
    private String phoneNumber;
    @OneToMany(mappedBy = "client")
    @OnDelete(action = SET_NULL)
    private List<Order> orders;
    private String role;
}
