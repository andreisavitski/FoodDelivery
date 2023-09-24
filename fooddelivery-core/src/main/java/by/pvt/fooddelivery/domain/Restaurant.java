package by.pvt.fooddelivery.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = "fooddeliverysch", name = "food_establishment")
public class Restaurant {
    @Id
    @SequenceGenerator(name = "food_establishment_id", sequenceName = "food_establishment_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "food_establishment_id")
    private Long id;
    @Column(name = "food_id")
    private Long foodId;
    private String name;
    @Embedded
    private Address address;
    @Column(name = "phone_number")
    private String phoneNumber;
}
