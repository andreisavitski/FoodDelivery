package by.pvt.fooddelivery.domain;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@EqualsAndHashCode
@Setter
@Getter
@MappedSuperclass
public abstract class AbstractEntity {
    public static final String SEQUENCE_GENERATOR = "seq";
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_GENERATOR)
    private Long id;
}
