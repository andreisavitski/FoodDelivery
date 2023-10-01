package by.pvt.fooddelivery.service.impl;

import by.pvt.fooddelivery.domain.user.Courier;
import by.pvt.fooddelivery.repository.CourierRepository;
import by.pvt.fooddelivery.service.CourierApi;

import java.util.List;

public class CourierService implements CourierApi {
    private final CourierRepository courierRepository;

    public CourierService(CourierRepository courierRepository) {
        this.courierRepository = courierRepository;
    }

    @Override
    public void addCourier(Courier courier) {
        courierRepository.addCourier(courier);
    }

    @Override
    public Courier getCourierById(Long courierId) {
        return courierRepository.getCourierById(courierId).orElseThrow(
                () -> new RuntimeException("Courier does not exist"));
    }

    @Override
    public List<Courier> getAllCouriers() {
        return courierRepository.getAllCouriers();
    }

    @Override
    public void deleteCourierById(Long courierId) {
        courierRepository.deleteCourierById(courierId);
    }

    @Override
    public void updateCourier(Courier courier) {
        courierRepository.updateCourier(courier);
    }
}
