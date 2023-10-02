package by.pvt.fooddelivery.repository;

import by.pvt.fooddelivery.domain.user.Courier;

import java.util.List;
import java.util.Optional;

public interface CourierRepository {
    void addCourier(Courier courier);

    Optional<Courier> getCourierById(Long courierId);

    List<Courier> getAllCouriers();

    void deleteCourierById(Long courierId);

    void updateCourier(Courier courier);

}
