package by.pvt.fooddelivery.domain.payment;

import by.pvt.fooddelivery.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = "fooddeliverysch", name = "payment")
@Inheritance(strategy = InheritanceType.JOINED)
public class Payment {
    @Id
    @SequenceGenerator(name = "payment_id_seq", sequenceName = "payment_seq", allocationSize = 1, schema = "fooddeliverysch")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payment_id_seq")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private LocalDateTime paid;
}
