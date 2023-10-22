package by.pvt.fooddelivery.service.impl;

import by.pvt.fooddelivery.dto.CourierDTO;
import by.pvt.fooddelivery.mapper.CourierMapper;
import by.pvt.fooddelivery.repository.CourierRepository;
import by.pvt.fooddelivery.service.CourierApi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourierService implements CourierApi {
    private final CourierRepository courierRepository;
    private final CourierMapper courierMapper;

    @Override
    public void registration(CourierDTO courierDTO) {
        courierRepository.addCourier(courierMapper.toCourier(courierDTO));
    }

    @Override
    public CourierDTO getCourierById(Long courierId) {
        return courierMapper.toDTO(courierRepository.getCourierById(courierId).orElseThrow(
                () -> new RuntimeException("Courier does not exist")));
    }

    @Override
    public List<CourierDTO> getAllCouriers() {
        return courierRepository.getAllCouriers().stream().map(courierMapper::toDTO).toList();
    }

    @Override
    public void deleteCourierById(Long courierId) {
        courierRepository.deleteCourierById(courierId);
    }

    @Override
    public void updateCourier(CourierDTO courierDTO) {
        courierRepository.updateCourier(courierMapper.toCourier(courierDTO));
    }
}
