package by.pvt.fooddelivery.domain;

import by.pvt.fooddelivery.enam.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = "fooddeliverysch", name = "order")
public class Order {
    @Id
    @SequenceGenerator(name = "order_id", sequenceName = "order_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_id")
    private Long id;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "total_cost")
    private BigDecimal totalCost;
    @Column(name = "order_status")
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
    private LocalDateTime ordered;
}
