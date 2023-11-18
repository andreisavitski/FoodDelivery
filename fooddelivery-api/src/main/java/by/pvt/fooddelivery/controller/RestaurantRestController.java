package by.pvt.fooddelivery.controller;

import by.pvt.fooddelivery.dto.RestaurantDTO;
import by.pvt.fooddelivery.logging.Logging;
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

    @Logging
    @GetMapping
    public List<RestaurantDTO> getRestaurants() {
        return restaurantService.findAllRestaurants();
    }

    @Logging
    @PostMapping
    public RestaurantDTO addRestaurant(@RequestBody @Validated RestaurantDTO dto) {
        return restaurantService.addRestaurant(dto);
    }

    @Logging
    @GetMapping("{id}")
    public RestaurantDTO getRestaurant(@PathVariable("id") Long id) {
        return restaurantService.findRestaurantById(id);
    }

    @Logging
    @PutMapping
    public RestaurantDTO updateRestaurant(@RequestBody @Validated RestaurantDTO dto) {
        return restaurantService.updateRestaurant(dto);
    }

    @Logging
    @DeleteMapping("{id}")
    public void deleteRestaurant(@PathVariable("id") Long id) {
        restaurantService.deleteRestaurantById(id);
    }
}
