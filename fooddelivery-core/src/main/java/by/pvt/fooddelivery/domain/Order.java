package by.pvt.fooddelivery.domain;

import by.pvt.fooddelivery.domain.user.User;
import by.pvt.fooddelivery.enums.OrderStatus;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = "fooddeliverysch", name = "order")
public class Order {
    @Id
    @SequenceGenerator(name = "order_id_seq", sequenceName = "order_seq", allocationSize = 1, schema = "fooddeliverysch")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_id_seq")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @OneToMany(mappedBy = "order", cascade = CascadeType.REMOVE)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<Cart> carts;
    @Column(name = "total_cost")
    private BigDecimal totalCost;
    @Column(name = "order_status")
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
    private LocalDateTime ordered;
    private List<Food> foods;
}
