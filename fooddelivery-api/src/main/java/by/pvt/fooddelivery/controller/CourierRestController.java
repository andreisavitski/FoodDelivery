package by.pvt.fooddelivery.controller;

import by.pvt.fooddelivery.dto.CourierRequest;
import by.pvt.fooddelivery.dto.CourierResponse;
import by.pvt.fooddelivery.logging.Logging;
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

    @Logging
    @GetMapping
    public List<CourierResponse> getClients() {
        return courierService.findAllCouriers();
    }

    @Logging
    @PostMapping("register")
    public CourierResponse addCourier(@RequestBody @Validated CourierRequest dto) {
        return courierService.register(dto);
    }

    @Logging
    @GetMapping("{id}")
    public CourierResponse getCourier(@PathVariable("id") Long id) {
        return courierService.findCourierById(id);
    }

    @Logging
    @PutMapping
    public CourierResponse updateCourier(@RequestBody @Validated CourierRequest dto) {
        return courierService.updateCourier(dto);
    }

    @Logging
    @DeleteMapping("{id}")
    public void deleteCourier(@PathVariable("id") Long id) {
        courierService.deleteCourierById(id);
    }
}
