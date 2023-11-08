package by.pvt.fooddelivery.domain;

import by.pvt.fooddelivery.enums.ProductType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

import static by.pvt.fooddelivery.domain.AbstractEntity.SEQUENCE_GENERATOR;
import static jakarta.persistence.EnumType.*;
import static jakarta.persistence.FetchType.*;
import static org.hibernate.annotations.CacheConcurrencyStrategy.READ_ONLY;

@Getter
@Setter
@Entity
@Table(name = "product")
@Cacheable
@org.hibernate.annotations.Cache(usage = READ_ONLY, region = "product")
@SequenceGenerator(name = SEQUENCE_GENERATOR, sequenceName = "product_seq", allocationSize = 1)
public class Product extends AbstractEntity {
    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;
    private String name;
    private String description;
    private BigDecimal price;
    @Enumerated(STRING)
    private ProductType type;
    @ManyToMany(mappedBy = "products", fetch = EAGER)
    private List<Order> orders;
}
