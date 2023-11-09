package by.pvt.fooddelivery.domain;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

import static by.pvt.fooddelivery.domain.AbstractEntity.SEQUENCE_GENERATOR;
import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.FetchType.EAGER;
import static org.hibernate.annotations.CacheConcurrencyStrategy.READ_ONLY;

@Getter
@Setter
@Entity
@Table(name = "restaurant")
@Cacheable
@org.hibernate.annotations.Cache(usage = READ_ONLY, region = "restaurant")
@SequenceGenerator(name = SEQUENCE_GENERATOR, sequenceName = "restaurant_seq", allocationSize = 1)
public class Restaurant extends AbstractEntity {
    @Column(unique = true)
    private String name;
    @Embedded
    private Address address;
    @Column(name = "phone_number")
    private String phoneNumber;
    @OneToMany(mappedBy = "restaurant", cascade = ALL, fetch = EAGER)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<Product> products;
}
