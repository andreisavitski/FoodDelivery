package by.pvt.fooddelivery.domain.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = "fooddeliverysch", name = "courier")
public class Courier extends User {
    @Column(name = "phone_number")
    private String phoneNumber;
}
