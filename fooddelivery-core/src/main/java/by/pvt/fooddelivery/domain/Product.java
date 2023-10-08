package by.pvt.fooddelivery.domain;

import by.pvt.fooddelivery.enums.ProductType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;

@EqualsAndHashCode
@Getter
@Setter
@ToString
@Entity
@Cacheable
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;
    private String name;
    private String description;
    private BigDecimal price;
    @Enumerated(EnumType.STRING)
    private ProductType type;
}
