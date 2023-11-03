package by.pvt.fooddelivery.domain;

import by.pvt.fooddelivery.enums.ProductType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "product")
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_ONLY, region = "product")
@SequenceGenerator(name = AbstractEntity.SEQUENCE_GENERATOR, sequenceName = "product_seq", allocationSize = 1)
public class Product extends AbstractEntity {
    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;
    private String name;
    private String description;
    private BigDecimal price;
    @Enumerated(EnumType.STRING)
    private ProductType type;
    @ManyToMany(mappedBy = "products")
    private List<Order> orders;
}
