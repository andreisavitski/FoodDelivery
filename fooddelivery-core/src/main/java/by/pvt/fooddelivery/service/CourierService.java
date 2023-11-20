package by.pvt.fooddelivery.service;

import by.pvt.fooddelivery.dto.CourierDTO;

import java.util.List;

public interface CourierService {
    CourierDTO registration(CourierDTO courierDTO);

    void deleteCourierById(Long courierId);

    CourierDTO findCourierById(Long courierId);

    List<CourierDTO> findAllCouriers();

    CourierDTO updateCourier(CourierDTO courierDTO);
}
