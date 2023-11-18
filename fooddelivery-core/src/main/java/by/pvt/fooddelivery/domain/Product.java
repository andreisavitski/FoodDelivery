package by.pvt.fooddelivery.domain;

import by.pvt.fooddelivery.enums.ProductType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

import static by.pvt.fooddelivery.domain.AbstractEntity.SEQUENCE_GENERATOR;
import static jakarta.persistence.EnumType.STRING;
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
}
