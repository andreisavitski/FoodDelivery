package by.pvt.fooddelivery.service;

import by.pvt.fooddelivery.dto.CourierDTO;

import java.util.List;

public interface CourierService {
    void registration(CourierDTO courierDTO);

    void deleteCourierById(Long courierId);

    CourierDTO findCourierById(Long courierId);

    List<CourierDTO> findAllCouriers();

    void updateCourier(CourierDTO courierDTO);
}
