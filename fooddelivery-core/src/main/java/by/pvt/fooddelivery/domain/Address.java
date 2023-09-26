package by.pvt.fooddelivery.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Address {
    private String city;
    private String street;
    @Column(name = "number_of_house")
    private String numberOfHouse;
    private String index;
}
