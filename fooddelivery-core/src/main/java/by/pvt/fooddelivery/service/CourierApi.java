package by.pvt.fooddelivery.service;

import by.pvt.fooddelivery.dto.CourierDTO;

import java.util.List;

public interface CourierApi {
    void registration(CourierDTO courierDTO);

    CourierDTO getCourierById(Long courierId);

    List<CourierDTO> getAllCouriers();

    void deleteCourierById(Long courierId);

    void updateCourier(CourierDTO courierDTO);
}
