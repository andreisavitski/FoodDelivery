package by.pvt.fooddelivery.domain.payment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = "fooddeliverysch", name = "cash")
public class Cash extends Payment {
    @Id
    @SequenceGenerator(name = "credit_card_id", sequenceName = "credit_card_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "credit_card_id")
    private Long id;
}
