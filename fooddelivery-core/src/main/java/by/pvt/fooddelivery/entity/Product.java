package by.pvt.fooddelivery.entity;

import by.pvt.fooddelivery.enums.ProductType;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

import static jakarta.persistence.EnumType.STRING;

@Getter
@Setter
@Entity
@Table(name = "product")
@NamedEntityGraph(name = "product_entity-graph", attributeNodes = @NamedAttributeNode("restaurant"))
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

    @ManyToMany(mappedBy = "products")
    private List<Order> orders;
}
