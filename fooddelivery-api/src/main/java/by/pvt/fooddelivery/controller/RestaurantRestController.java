package by.pvt.fooddelivery.controller;

import by.pvt.fooddelivery.dto.RestaurantDTO;
import by.pvt.fooddelivery.logging.MethodLogging;
import by.pvt.fooddelivery.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("restaurant")
@RequiredArgsConstructor
public class RestaurantRestController {
    private final RestaurantService restaurantService;

    @MethodLogging
    @GetMapping
    public List<RestaurantDTO> getRestaurants() {
        return restaurantService.findAllRestaurants();
    }

    @MethodLogging
    @PostMapping
    public RestaurantDTO addRestaurant(@RequestBody @Validated RestaurantDTO dto) {
        return restaurantService.addRestaurant(dto);
    }

    @MethodLogging
    @GetMapping("{id}")
    public RestaurantDTO getRestaurant(@PathVariable("id") Long id) {
        return restaurantService.findRestaurantById(id);
    }

    @MethodLogging
    @PutMapping
    public RestaurantDTO updateRestaurant(@RequestBody @Validated RestaurantDTO dto) {
        return restaurantService.updateRestaurant(dto);
    }

    @MethodLogging
    @DeleteMapping("{id}")
    public void deleteRestaurant(@PathVariable("id") Long id) {
        restaurantService.deleteRestaurantById(id);
    }
}
