package by.pvt.fooddelivery.service.impl;

import by.pvt.fooddelivery.domain.Courier;
import by.pvt.fooddelivery.dto.CourierRequest;
import by.pvt.fooddelivery.dto.CourierResponse;
import by.pvt.fooddelivery.exception.ApplicationException;
import by.pvt.fooddelivery.mapper.CourierMapper;
import by.pvt.fooddelivery.repository.CourierRepository;
import by.pvt.fooddelivery.service.CourierService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static by.pvt.fooddelivery.exception.ApplicationError.COURIER_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class CourierServiceImpl implements CourierService {
    private final CourierRepository courierRepository;
    private final CourierMapper courierMapper;

    @Override
    @Transactional
    public CourierResponse register(CourierRequest courierRequest) {
        return courierMapper.toDTO(courierRepository.save(courierMapper.toCourier(courierRequest)));
    }

    @Override
    public CourierResponse authorize(CourierRequest courierRequest) {
        Courier courier = courierRepository.findByEmail(courierRequest.getEmail()).orElseThrow(() -> new ApplicationException(COURIER_NOT_FOUND));
        if (courier.getPassword().equals(courierRequest.getPassword())) {
            return courierMapper.toDTO(courier);
        } else {
            throw new ApplicationException(COURIER_NOT_FOUND);
        }
    }

    @Override
    @Transactional
    public void deleteCourierById(Long courierId) {
        courierRepository.delete(courierMapper.toCourier(findCourierById(courierId)));
    }

    @Override
    public CourierResponse findCourierById(Long courierId) {
        return courierMapper.toDTO(courierRepository.findById(courierId).orElseThrow(() -> new ApplicationException(COURIER_NOT_FOUND)));
    }

    @Override
    public List<CourierResponse> findAllCouriers() {
        List<CourierResponse> couriers = courierRepository.findAll().stream().map(courierMapper::toDTO).toList();
        if (couriers.isEmpty()) {
            throw new ApplicationException(COURIER_NOT_FOUND);
        }
        return couriers;
    }

    @Override
    @Transactional
    public CourierResponse updateCourier(CourierRequest courierRequest) {
        return courierMapper.toDTO(courierRepository.save(courierMapper.toCourier(courierRequest)));
    }
}
