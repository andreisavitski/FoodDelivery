package by.pvt.fooddelivery.domain;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

import static by.pvt.fooddelivery.domain.AbstractEntity.SEQUENCE_GENERATOR;
import static jakarta.persistence.CascadeType.REMOVE;
import static jakarta.persistence.FetchType.EAGER;

@Getter
@Setter
@Entity
@Table(name = "restaurant")
@SequenceGenerator(name = SEQUENCE_GENERATOR, sequenceName = "restaurant_seq", allocationSize = 1)
public class Restaurant extends AbstractEntity {
    @Column(name = "name", unique = true)
    private String name;
    @Embedded
    private Address address;
    @Column(name = "phone_number", unique = true)
    private String phoneNumber;
    @OneToMany(mappedBy = "restaurant", cascade = REMOVE, fetch = EAGER)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<Product> products;
}
