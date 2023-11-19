package by.pvt.fooddelivery.mapper;

import by.pvt.fooddelivery.domain.Courier;
import by.pvt.fooddelivery.dto.CourierRequestDTO;
import by.pvt.fooddelivery.dto.CourierResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourierMapper {
    Courier toCourier(CourierRequestDTO courierRequestDTO);

    Courier toCourier(CourierResponseDTO courierResponseDTO);

    CourierResponseDTO toDTO(Courier courier);
}
