package by.pvt.fooddelivery.service.impl;

import by.pvt.fooddelivery.domain.Courier;
import by.pvt.fooddelivery.dto.CourierRequest;
import by.pvt.fooddelivery.dto.CourierResponse;
import by.pvt.fooddelivery.exception.ApplicationException;
import by.pvt.fooddelivery.mapper.CourierMapper;
import by.pvt.fooddelivery.repository.CourierRepository;
import by.pvt.fooddelivery.service.CourierService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static by.pvt.fooddelivery.constant.Constant.COURIER;
import static by.pvt.fooddelivery.enums.CourierStatus.FREE;
import static by.pvt.fooddelivery.exception.ApplicationError.COURIER_NOT_ADDED;
import static by.pvt.fooddelivery.exception.ApplicationError.COURIER_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class CourierServiceImpl implements CourierService {
    private final CourierRepository courierRepository;
    private final CourierMapper courierMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public CourierResponse register(CourierRequest courierRequest) {
        Courier courier = courierMapper.toCourier(courierRequest);
        courier.setPassword(passwordEncoder.encode(courierRequest.getPassword()));
        courier.setStatus(FREE);
        courier.setRole(COURIER);
        return courierMapper.toDTO(courierRepository.save(checkingUniqueLoginAndPhoneNumber(courier)));
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
        findCourierById(courierRequest.getId());
        return courierMapper.toDTO(courierRepository.save(checkingUniqueLoginAndPhoneNumber(courierMapper.toCourier(courierRequest))));
    }

    private Courier checkingUniqueLoginAndPhoneNumber(Courier courier) {
        if (!courierRepository.findAll().stream().filter(c -> c.getLogin().equals(courier.getLogin())).filter(c -> c.getPhoneNumber().equals(courier.getPhoneNumber())).toList().isEmpty()) {
            throw new ApplicationException(COURIER_NOT_ADDED);
        }
        return courier;
    }
}
