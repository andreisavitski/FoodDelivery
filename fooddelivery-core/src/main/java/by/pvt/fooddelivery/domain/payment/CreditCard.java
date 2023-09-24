package by.pvt.fooddelivery.domain.payment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = "fooddeliverysch", name = "credit_card")
public class CreditCard extends Payment {
    @Id
    @SequenceGenerator(name = "credit_card_id", sequenceName = "credit_card_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "credit_card_id")
    private Long id;
    private String cardNumber;
    private String cardType;
}
