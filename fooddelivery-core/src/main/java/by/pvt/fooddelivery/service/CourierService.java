package by.pvt.fooddelivery.service;

import by.pvt.fooddelivery.dto.CourierRequest;
import by.pvt.fooddelivery.dto.CourierResponse;

import java.util.List;

public interface CourierService {
    CourierResponse register(CourierRequest courierRequest);

    CourierResponse authorize(CourierRequest courierRequest);

    void deleteCourierById(Long courierId);

    CourierResponse findCourierById(Long courierId);

    List<CourierResponse> findAllCouriers();

    CourierResponse updateCourier(CourierRequest courierRequest);
}
