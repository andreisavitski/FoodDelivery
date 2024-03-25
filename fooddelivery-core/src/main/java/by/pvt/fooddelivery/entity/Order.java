package by.pvt.fooddelivery.entity;

import by.pvt.fooddelivery.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.FetchType.EAGER;

@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @Column(name = "service_fee")
    private BigDecimal serviceFee;

    @Column(name = "cost_of_delivery")
    private BigDecimal costOfDelivery;

    @Column(name = "total_cost")
    private BigDecimal totalCost;

    @Column(name = "ordered")
    private LocalDateTime ordered;

    @ManyToMany(fetch = EAGER)
    @JoinTable(name = "orders_products",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products;

    @Column(name = "order_status")
    @Enumerated(STRING)
    private OrderStatus orderStatus;

    @ManyToOne
    @JoinColumn(name = "courier_id")
    private Courier courier;
}
