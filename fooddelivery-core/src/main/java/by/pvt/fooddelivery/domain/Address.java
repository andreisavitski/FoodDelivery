package by.pvt.fooddelivery.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@EqualsAndHashCode
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Embeddable
public class Address {
    private String city;
    private String street;
    @Column(name = "number_of_house")
    private String numberOfHouse;
    private String index;
}
