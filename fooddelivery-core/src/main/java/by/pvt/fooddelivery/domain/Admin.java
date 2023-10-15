package by.pvt.fooddelivery.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "admin")
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_ONLY, region = "admin")
@SequenceGenerator(name = AbstractEntity.SEQUENCE_GENERATOR, sequenceName = "admin_seq",
        allocationSize = 1, schema = "fooddeliverysch")
public class Admin extends AbstractEntity {
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String email;
    @Column(unique = true)
    private String login;
    private String password;
    @Column(name = "phone_number", unique = true)
    private String phoneNumber;
}
