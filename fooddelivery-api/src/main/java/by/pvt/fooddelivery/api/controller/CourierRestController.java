package by.pvt.fooddelivery.api.controller;

import by.pvt.fooddelivery.dto.CourierDTO;
import by.pvt.fooddelivery.service.CourierService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courier")
@RequiredArgsConstructor
public class CourierRestController {
    private final CourierService courierService;

    @GetMapping("/getAll")
    public List<CourierDTO> getClients() {
        return courierService.findAllCouriers();
    }


    @PostMapping("/addCourier")
    public CourierDTO addCourier(@RequestBody CourierDTO dto) {
        return courierService.registration(dto);
    }

    @GetMapping("/getCourier/{id}")
    public CourierDTO getCourier(@PathVariable("id") Long id) {
        return courierService.findCourierById(id);
    }

    @PutMapping("/updateCourier")
    public CourierDTO updateCourier(@RequestBody CourierDTO dto) {
        return courierService.updateCourier(dto);
    }

    @DeleteMapping("/deleteCourier/{id}")
    public void deleteCourier(@PathVariable("id") Long id) {
        courierService.deleteCourierById(id);
    }
}
