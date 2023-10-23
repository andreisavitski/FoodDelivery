package by.pvt.fooddelivery.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "client")
@SequenceGenerator(name = AbstractEntity.SEQUENCE_GENERATOR, sequenceName = "client_seq",
        allocationSize = 1, schema = "fooddeliverysch")
public class Client extends AbstractEntity {
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String email;
    @Column(unique = true)
    private String login;
    private String password;
    @Embedded
    private Address address;
    @Column(name = "phone_number", unique = true)
    private String phoneNumber;
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Order> orders;
}
