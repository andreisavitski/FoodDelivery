package by.pvt.fooddelivery.mapper;

import by.pvt.fooddelivery.domain.Order;
import by.pvt.fooddelivery.dto.OrderDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ClientMapper.class, ProductMapper.class})
public interface OrderMapper {
    Order toOrder(OrderDTO orderDTO);

    OrderDTO toDTO(Order order);
}
