package by.pvt.fooddelivery.domain;

import by.pvt.fooddelivery.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

import static by.pvt.fooddelivery.domain.AbstractEntity.SEQUENCE_GENERATOR;
import static jakarta.persistence.CascadeType.*;
import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.FetchType.EAGER;
import static org.hibernate.annotations.OnDeleteAction.CASCADE;
import static org.hibernate.annotations.OnDeleteAction.SET_NULL;

@Getter
@Setter
@Entity
@Table(name = "orders")
@SequenceGenerator(name = SEQUENCE_GENERATOR, sequenceName = "order_seq", allocationSize = 1)
public class Order extends AbstractEntity {
    @ManyToOne
    @JoinColumn(name = "client_id")
    @OnDelete(action = SET_NULL)
    private Client client;
    @JoinColumn(name = "service_fee")
    private BigDecimal serviceFee;
    @JoinColumn(name = "cost_of_delivery")
    private BigDecimal costOfDelivery;
    @Column(name = "total_cost")
    private BigDecimal totalCost;
    private LocalDateTime ordered;
    @ElementCollection(fetch = EAGER)
    @CollectionTable(name = "orders_product",
            joinColumns = @JoinColumn(name = "orders_id"))
    @MapKeyJoinColumn(name = "product_id")
    @Column(name = "count")
    private Map<Product, Long> products;
    @Column(name = "order_status")
    @Enumerated(STRING)
    private OrderStatus orderStatus;
    @ManyToOne
    @JoinColumn(name = "courier_id")
    private Courier courier;
}
