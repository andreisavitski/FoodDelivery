package by.pvt.fooddelivery.repository.product.jdbctemplate;

import by.pvt.fooddelivery.entity.Product;
import by.pvt.fooddelivery.repository.product.mapper.ProductRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Qualifier(value = "jdbcTemplate")
public class JdbcTemplateProductRepositoryImpl implements JdbcTemplateProductRepository {

    private final JdbcTemplate jdbcTemplate;

    private final ProductRowMapper productRowMapper;

    @Override
    public List<Product> findByRestaurantId(Long restaurantId) {
        return jdbcTemplate.query("""
                        select
                            prod.id,
                            prod.name,
                            prod.description,
                            prod.price,
                            prod.type,
                            rest.id as restaurant_id,
                            rest.name as restaurant_name,
                            rest.phone_number,
                            rest.city,
                            rest.street,
                            rest.number_of_house,
                            rest.index
                        from fooddeliverysch.product prod
                        join fooddeliverysch.restaurant rest on prod.restaurant_id = rest.id
                        where rest.id = ?;\040""",
                productRowMapper, restaurantId);
    }
}
