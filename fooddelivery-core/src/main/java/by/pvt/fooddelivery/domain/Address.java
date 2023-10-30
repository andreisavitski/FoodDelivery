package by.pvt.fooddelivery.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class Address {
    private String city;
    private String street;
    @Column(name = "number_of_house")
    private String numberOfHouse;
    private String index;
}