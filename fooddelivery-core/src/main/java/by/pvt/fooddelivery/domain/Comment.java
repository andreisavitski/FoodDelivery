package by.pvt.fooddelivery.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "comment")
@SequenceGenerator(name = AbstractEntity.SEQUENCE_GENERATOR, sequenceName = "comment_seq",
        allocationSize = 1, schema = "fooddeliverysch")
public class Comment extends AbstractEntity {
    private Long id;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;
    @ManyToOne
    @JoinColumn(name = "courier_id")
    private Courier courier;
    @Column(length = 2000)
    private String text;
}
