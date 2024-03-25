package by.pvt.fooddelivery.repository.product.mapper;

import by.pvt.fooddelivery.entity.Address;
import by.pvt.fooddelivery.entity.Product;
import by.pvt.fooddelivery.entity.Restaurant;
import by.pvt.fooddelivery.enums.ProductType;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ProductRowMapper implements RowMapper<Product> {
    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        Product product = new Product();
        Restaurant restaurant = new Restaurant();
        Address address = new Address();
        address.setCity(rs.getString("city"));
        address.setStreet(rs.getString("street"));
        address.setNumberOfHouse(rs.getString("number_of_house"));
        address.setIndex(rs.getString("index"));
        restaurant.setId(rs.getLong("id"));
        restaurant.setName(rs.getString("restaurant_name"));
        restaurant.setPhoneNumber(rs.getString("phone_number"));
        restaurant.setAddress(address);
        product.setId(rs.getLong("id"));
        product.setName(rs.getString("name"));
        product.setDescription(rs.getString("description"));
        product.setType(ProductType.valueOf(rs.getString("type")));
        product.setPrice(rs.getBigDecimal("price"));
        product.setRestaurant(restaurant);
        return product;
    }
}
