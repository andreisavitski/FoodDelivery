package by.pvt.fooddelivery.domain;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import static jakarta.persistence.GenerationType.SEQUENCE;

@EqualsAndHashCode
@Setter
@Getter
@MappedSuperclass
public abstract class AbstractEntity {
    public static final String SEQUENCE_GENERATOR = "seq";
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = SEQUENCE_GENERATOR)
    private Long id;
}
