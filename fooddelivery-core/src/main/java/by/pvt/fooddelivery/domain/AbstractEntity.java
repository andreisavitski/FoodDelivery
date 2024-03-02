package by.pvt.fooddelivery.domain;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import static by.pvt.fooddelivery.constant.AppConstants.SEQUENCE_GENERATOR;
import static jakarta.persistence.GenerationType.SEQUENCE;

@Setter
@Getter
@MappedSuperclass
public abstract class AbstractEntity {
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = SEQUENCE_GENERATOR)
    private Long id;
}
