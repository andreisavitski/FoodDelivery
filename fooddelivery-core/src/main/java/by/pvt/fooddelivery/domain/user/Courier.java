package by.pvt.fooddelivery.domain.user;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Getter
@Setter
@ToString(callSuper = true)
@Entity
@Table(name = "courier")
@PrimaryKeyJoinColumn(name = "id")
public class Courier extends User {
}
