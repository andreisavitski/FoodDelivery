package by.pvt.fooddelivery.service;

import by.pvt.fooddelivery.dto.CourierRequestDTO;
import by.pvt.fooddelivery.dto.CourierResponseDTO;

import java.util.List;

public interface CourierService {
    CourierResponseDTO register(CourierRequestDTO courierRequestDTO);

    void deleteCourierById(Long courierId);

    CourierResponseDTO findCourierById(Long courierId);

    List<CourierResponseDTO> findAllCouriers();

    CourierResponseDTO updateCourier(CourierRequestDTO courierRequestDTO);
}
