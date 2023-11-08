package by.pvt.fooddelivery.domain;

import by.pvt.fooddelivery.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static by.pvt.fooddelivery.domain.AbstractEntity.*;
import static jakarta.persistence.EnumType.*;
import static jakarta.persistence.FetchType.*;

@Getter
@Setter
@Entity
@Table(name = "orders")
@SequenceGenerator(name = SEQUENCE_GENERATOR, sequenceName = "order_seq", allocationSize = 1)
public class Order extends AbstractEntity {
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    @Column(name = "total_cost")
    private BigDecimal totalCost;
    private LocalDateTime ordered;
    @ManyToMany(fetch = EAGER)
    @JoinTable(name = "orders_product",
            joinColumns = @JoinColumn(name = "orders_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products;
    @Column(name = "order_status")
    @Enumerated(STRING)
    private OrderStatus orderStatus;
}
