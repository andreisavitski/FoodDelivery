package by.pvt.fooddelivery.domain.user;

import by.pvt.fooddelivery.domain.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = "fooddeliverysch", name = "client")
public class Client extends User {
    @Embedded
    private Address address;
    @Column(name = "phone_number")
    private String phoneNumber;
}
