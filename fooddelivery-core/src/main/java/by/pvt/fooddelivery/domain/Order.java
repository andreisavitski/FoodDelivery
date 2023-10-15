package by.pvt.fooddelivery.domain;

import by.pvt.fooddelivery.domain.user.Client;
import by.pvt.fooddelivery.enums.OrderStatus;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@EqualsAndHashCode
@Getter
@Setter
@ToString
@Entity
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    @Column(name = "total_cost")
    private BigDecimal totalCost;
    private LocalDateTime ordered;
    @OneToMany
    @JoinColumn(name = "product_id")
    private List<Product> products;
    @Column(name = "order_status")
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
}
