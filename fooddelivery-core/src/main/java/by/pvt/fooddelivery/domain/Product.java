package by.pvt.fooddelivery.domain;

import by.pvt.fooddelivery.enums.ProductType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

import static by.pvt.fooddelivery.domain.AbstractEntity.SEQUENCE_GENERATOR;
import static jakarta.persistence.EnumType.STRING;

@Getter
@Setter
@Entity
@Table(name = "product")
@SequenceGenerator(name = SEQUENCE_GENERATOR, sequenceName = "product_seq", allocationSize = 1)
public class Product extends AbstractEntity {
    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private BigDecimal price;
    @Enumerated(STRING)
    @Column(name = "type")
    private ProductType type;
}
