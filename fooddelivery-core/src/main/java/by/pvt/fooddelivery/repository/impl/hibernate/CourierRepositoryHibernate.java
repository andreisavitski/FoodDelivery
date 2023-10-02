package by.pvt.fooddelivery.repository.impl.hibernate;

import by.pvt.fooddelivery.domain.user.Courier;
import by.pvt.fooddelivery.repository.CourierRepository;

import java.util.List;
import java.util.Optional;

public class CourierRepositoryHibernate extends RepositoryCRUD implements CourierRepository {

    @Override
    public void addCourier(Courier courier) {
        add(courier);
    }

    @Override
    public Optional<Courier> getCourierById(Long courierId) {
        return getById(Courier.class, courierId);
    }

    @Override
    public List<Courier> getAllCouriers() {
        return getAll(Courier.class);
    }

    @Override
    public void deleteCourierById(Long courierId) {
        deleteById(Courier.class, courierId);
    }

    @Override
    public void updateCourier(Courier courier) {
        update(courier);
    }
}
