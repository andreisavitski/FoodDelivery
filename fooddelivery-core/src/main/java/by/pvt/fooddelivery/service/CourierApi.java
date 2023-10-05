package by.pvt.fooddelivery.service;

import by.pvt.fooddelivery.domain.user.Courier;

import java.util.List;

public interface CourierApi {
    void addCourier(Courier courier);

    Courier getCourierById(Long courierId);

    List<Courier> getAllCouriers();

    void deleteCourierById(Long courierId);

    void updateCourier(Courier courier);
}