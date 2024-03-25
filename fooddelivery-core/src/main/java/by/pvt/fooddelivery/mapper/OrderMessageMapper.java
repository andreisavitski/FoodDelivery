package by.pvt.fooddelivery.mapper;

import by.pvt.fooddelivery.dto.OrderMessageDTO;
import by.pvt.fooddelivery.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = OrderMessageMapper.class)
public interface OrderMessageMapper {
    @Mapping(source = "client.id", target = "clientId")
    @Mapping(source = "courier.id", target = "courierId")
    @Mapping(source = "ordered", target = "orderDate")
    @Mapping(source = "totalCost", target = "totalCost")
    OrderMessageDTO toDTO(Order order);
}
