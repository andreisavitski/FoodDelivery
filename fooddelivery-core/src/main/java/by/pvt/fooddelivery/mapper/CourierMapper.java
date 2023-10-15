package by.pvt.fooddelivery.mapper;

import by.pvt.fooddelivery.domain.Courier;
import by.pvt.fooddelivery.dto.CourierDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourierMapper {
    Courier toCourier(CourierDTO courierDTO);

    CourierDTO toDTO(Courier courier);
}
