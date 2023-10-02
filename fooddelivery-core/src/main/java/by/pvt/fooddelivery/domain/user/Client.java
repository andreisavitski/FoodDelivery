package by.pvt.fooddelivery.domain.user;

import by.pvt.fooddelivery.domain.Address;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = "fooddeliverysch", name = "client")
@PrimaryKeyJoinColumn(name = "id")
public class Client extends User {
    @Embedded
    private Address address;
    @Column(name = "phone_number")
    private String phoneNumber;
}
