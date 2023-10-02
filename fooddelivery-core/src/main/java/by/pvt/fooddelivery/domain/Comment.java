package by.pvt.fooddelivery.domain;

import by.pvt.fooddelivery.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = "fooddeliverysch", name = "comment")
public class Comment {
    @Id
    @SequenceGenerator(name = "comment_id_seq", sequenceName = "comment_seq", allocationSize = 1, schema = "fooddeliverysch")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comment_id_seq")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Column(length = 2000)
    private String text;
}
