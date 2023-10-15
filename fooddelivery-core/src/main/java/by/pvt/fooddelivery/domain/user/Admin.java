package by.pvt.fooddelivery.domain.user;

import lombok.*;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Getter
@Setter
@ToString(callSuper = true)
@Entity
@Cacheable
@Table(name = "admin")
@PrimaryKeyJoinColumn(name = "id")
public class Admin extends User {
}
