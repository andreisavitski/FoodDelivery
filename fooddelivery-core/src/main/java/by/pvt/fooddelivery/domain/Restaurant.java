package by.pvt.fooddelivery.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = "fooddeliverysch", name = "restaurant")
public class Restaurant {
    @Id
    @SequenceGenerator(name = "restaurant_id_seq", sequenceName = "restaurant_seq", allocationSize = 1, schema = "fooddeliverysch")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "restaurant_id_seq")
    private Long id;
    private String name;
    @Embedded
    private Address address;
    @Column(name = "phone_number")
    private String phoneNumber;
}
