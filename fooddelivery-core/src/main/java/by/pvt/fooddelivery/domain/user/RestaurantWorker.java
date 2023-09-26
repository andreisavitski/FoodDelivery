package by.pvt.fooddelivery.domain.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = "fooddeliverysch", name = "food_establishment_worker")

public class RestaurantWorker extends User {
    @Column(name = "food_establishment_id")
    private Long foodEstablishmentId;
}
