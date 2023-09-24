package by.pvt.fooddelivery.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = "fooddeliverysch", name = "cart")
public class Cart {
    @Id
    @SequenceGenerator(name = "cart_id", sequenceName = "cart_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cart_id")
    private Long id;
    @Column(name = "order_id")
    private Long orderId;
    @Column (name = "food_id")
    private Long foodId;
    private Integer quantity;
}
