package by.pvt.fooddelivery.mapper;

import by.pvt.fooddelivery.domain.Order;
import by.pvt.fooddelivery.dto.OrderDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {ClientMapper.class, ProductMapper.class})
public interface OrderMapper {
    @Mapping(source = "courierResponse", target = "courier")
    @Mapping(source = "products", target = "products")
    @Mapping(source = "clientLogin", target = "client.login")
    Order toOrder(OrderDTO orderDTO);
    @Mapping(source = "courier", target = "courierResponse")
    @Mapping(source = "client.login", target = "clientLogin")
    @Mapping(source = "products", target = "products")
    OrderDTO toDTO(Order order);
}
