package by.pvt.fooddelivery.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = "fooddeliverysch", name = "food")
public class Food {
    @Id
    @SequenceGenerator(name = "food_id_seq", sequenceName = "food_seq", allocationSize = 1, schema = "fooddeliverysch")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "food_id_seq")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;
    private String name;
    private String description;
    private BigDecimal price;
    @Column(name = "type_of_food")
    private String typeOfFood;
}
