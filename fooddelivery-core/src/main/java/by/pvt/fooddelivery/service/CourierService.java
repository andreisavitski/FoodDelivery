package by.pvt.fooddelivery.service;

import by.pvt.fooddelivery.dto.CourierRequestDTO;
import by.pvt.fooddelivery.dto.CourierResponseDTO;
import by.pvt.fooddelivery.dto.security.JwtAuthenticationResponseDTO;
import by.pvt.fooddelivery.dto.security.SignInRequestDTO;

import java.util.List;

public interface CourierService {
    JwtAuthenticationResponseDTO signUp(CourierRequestDTO courierRequestDTO);

    JwtAuthenticationResponseDTO signIn(SignInRequestDTO request);

    void deleteCourierById(Long courierId);

    CourierResponseDTO findCourierById(Long courierId);

    List<CourierResponseDTO> findAllCouriers();

    CourierResponseDTO updateCourier(CourierRequestDTO courierRequestDTO);
}
