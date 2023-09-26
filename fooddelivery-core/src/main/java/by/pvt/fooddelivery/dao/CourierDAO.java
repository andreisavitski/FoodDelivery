package by.pvt.fooddelivery.dao;

import by.pvt.fooddelivery.domain.user.Courier;

import java.util.List;

public interface CourierDAO {
    void addCourier(Courier courier);

    Courier getCourierById(Long id);

    List<Courier> getAllCouriers();

    void deleteCourierById(Long id);
}
