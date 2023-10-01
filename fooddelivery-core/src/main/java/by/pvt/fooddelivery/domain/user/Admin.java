package by.pvt.fooddelivery.domain.user;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Getter
@Setter
@ToString(callSuper = true)
@Entity
@Table(schema = "fooddeliverysch", name = "admin")
@PrimaryKeyJoinColumn(name = "id")
public class Admin extends User {
}
