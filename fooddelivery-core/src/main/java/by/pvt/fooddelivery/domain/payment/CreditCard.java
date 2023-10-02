package by.pvt.fooddelivery.domain.payment;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Getter
@Setter
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = "fooddeliverysch", name = "credit_card")
@PrimaryKeyJoinColumn(name = "id")
public class CreditCard extends Payment {
    private String cardNumber;
    private String cardType;
}
