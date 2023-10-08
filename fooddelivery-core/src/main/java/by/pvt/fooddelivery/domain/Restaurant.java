package by.pvt.fooddelivery.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode
@Getter
@Setter
@ToString
@Entity
@Cacheable
@Table(name = "restaurant")
public class Restaurant {
    @Id
    @GeneratedValue
    private Long id;
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
