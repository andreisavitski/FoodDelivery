package by.pvt.fooddelivery.domain.payment;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Getter
@Setter
@ToString(callSuper = true)
@Entity
@Table(schema = "fooddeliverysch", name = "cash")
@PrimaryKeyJoinColumn(name = "id")
public class Cash extends Payment {
}
