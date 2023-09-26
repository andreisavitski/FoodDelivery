package by.pvt.fooddelivery.domain.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Inheritance(strategy = InheritanceType.JOINED)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = "fooddeliverysch", name = "user")
public class User {
    @Id
    @SequenceGenerator(name = "user_id", sequenceName = "user_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id")
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String login;
    private String password;
}
