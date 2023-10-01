package by.pvt.fooddelivery.domain.user;

import by.pvt.fooddelivery.domain.Restaurant;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = "fooddeliverysch", name = "restaurant_employee")
@PrimaryKeyJoinColumn(name = "id")

public class RestaurantEmployee extends User {
    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;
}
