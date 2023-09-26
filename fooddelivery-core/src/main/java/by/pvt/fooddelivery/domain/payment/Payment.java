package by.pvt.fooddelivery.domain.payment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Inheritance(strategy = InheritanceType.JOINED)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = "fooddeliverysch", name = "payment")
public class Payment {
    @Id
    @SequenceGenerator(name = "payment_id", sequenceName = "payment_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payment_id")
    private Long id;
    @Column(name = "user_id")
    private Long userId;
    private LocalDateTime paid;
}
