package by.pvt.fooddelivery.service.impl;

import by.pvt.fooddelivery.dao.CourierDAO;
import by.pvt.fooddelivery.domain.user.Courier;
import by.pvt.fooddelivery.service.CourierApi;

import java.util.List;

public class CourierService implements CourierApi {
    private final CourierDAO courierDAO;

    public CourierService(CourierDAO courierDAO) {
        this.courierDAO = courierDAO;
    }

    @Override
    public void addCourier(Courier courier) {
        courierDAO.addCourier(courier);
    }

    @Override
    public Courier getCourierById(Long id) {
        return courierDAO.getCourierById(id);
    }

    @Override
    public List<Courier> getAllCouriers() {
        return courierDAO.getAllCouriers();
    }

    @Override
    public void deleteCourierById(Long id) {
        courierDAO.deleteCourierById(id);
    }
}
