package by.pvt.fooddelivery.service.impl;

import by.pvt.fooddelivery.dto.CourierDTO;
import by.pvt.fooddelivery.mapper.CourierMapper;
import by.pvt.fooddelivery.repository.CourierRepository;
import by.pvt.fooddelivery.service.CourierService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourierServiceImpl implements CourierService {
    private final CourierRepository courierRepository;
    private final CourierMapper courierMapper;

    @Override
    @Transactional
    public CourierDTO registration(CourierDTO courierDTO) {
        return courierMapper.toDTO(courierRepository.save(courierMapper.toCourier(courierDTO)));
    }

    @Override
    @Transactional
    public void deleteCourierById(Long courierId) {
        courierRepository.deleteById(courierId);
    }

    @Override
    public CourierDTO findCourierById(Long courierId) {
        return courierMapper.toDTO(courierRepository.findById(courierId).orElseThrow(
                () -> new RuntimeException("Courier does not exist")));
    }

    @Override
    public List<CourierDTO> findAllCouriers() {
        return courierRepository.findAll().stream().map(courierMapper::toDTO).toList();
    }

    @Override
    @Transactional
    public CourierDTO updateCourier(CourierDTO courierDTO) {
        return courierMapper.toDTO(courierRepository.save(courierMapper.toCourier(courierDTO)));
    }
}
