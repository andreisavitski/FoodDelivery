package by.pvt.fooddelivery.domain;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "restaurant")
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_ONLY, region = "restaurant")
@SequenceGenerator(name = AbstractEntity.SEQUENCE_GENERATOR, sequenceName = "restaurant_seq",
        allocationSize = 1, schema = "fooddeliverysch")
public class Restaurant extends AbstractEntity {
    private String name;
    @Embedded
    private Address address;
    @Column(name = "phone_number")
    private String phoneNumber;
    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.REMOVE)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<Product> products;
}
