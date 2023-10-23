package by.pvt.fooddelivery.domain;

import by.pvt.fooddelivery.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "order")
@SequenceGenerator(name = AbstractEntity.SEQUENCE_GENERATOR, sequenceName = "order_seq",
        allocationSize = 1, schema = "fooddeliverysch")
public class Order extends AbstractEntity {
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    @Column(name = "total_cost")
    private BigDecimal totalCost;
    private LocalDateTime ordered;
    @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name = "order_product",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products;
    @Column(name = "order_status")
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
}
