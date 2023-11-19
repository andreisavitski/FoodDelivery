package by.pvt.fooddelivery.controller;

import by.pvt.fooddelivery.dto.CourierRequestDTO;
import by.pvt.fooddelivery.dto.CourierResponseDTO;
import by.pvt.fooddelivery.logging.MethodLogging;
import by.pvt.fooddelivery.service.CourierService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("courier")
@RequiredArgsConstructor
public class CourierRestController {
    private final CourierService courierService;

    @MethodLogging
    @GetMapping
    public List<CourierResponseDTO> getClients() {
        return courierService.findAllCouriers();
    }

    @MethodLogging
    @PostMapping("register")
    public CourierResponseDTO addCourier(@RequestBody @Validated CourierRequestDTO dto) {
        return courierService.register(dto);
    }

    @MethodLogging
    @GetMapping("{id}")
    public CourierResponseDTO getCourier(@PathVariable("id") Long id) {
        return courierService.findCourierById(id);
    }

    @MethodLogging
    @PutMapping
    public CourierResponseDTO updateCourier(@RequestBody @Validated CourierRequestDTO dto) {
        return courierService.updateCourier(dto);
    }

    @MethodLogging
    @DeleteMapping("{id}")
    public void deleteCourier(@PathVariable("id") Long id) {
        courierService.deleteCourierById(id);
    }
}
