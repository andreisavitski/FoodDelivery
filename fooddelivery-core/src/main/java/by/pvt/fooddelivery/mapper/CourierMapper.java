package by.pvt.fooddelivery.mapper;

import by.pvt.fooddelivery.domain.Courier;
import by.pvt.fooddelivery.dto.CourierRequest;
import by.pvt.fooddelivery.dto.CourierResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourierMapper {
    Courier toCourier(CourierRequest courierRequest);

    Courier toCourier(CourierResponse courierResponse);

    CourierResponse toDTO(Courier courier);
}
