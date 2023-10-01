package by.pvt.fooddelivery.domain.user;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Getter
@Setter
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = "fooddeliverysch", name = "courier")
@PrimaryKeyJoinColumn(name = "id")
public class Courier extends User {
    @Column(name = "phone_number")
    private String phoneNumber;
}
