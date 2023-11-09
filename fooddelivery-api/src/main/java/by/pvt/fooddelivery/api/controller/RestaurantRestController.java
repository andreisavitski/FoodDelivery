package by.pvt.fooddelivery.api.controller;

import by.pvt.fooddelivery.dto.RestaurantDTO;
import by.pvt.fooddelivery.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
@RequiredArgsConstructor
public class RestaurantRestController {
    private final RestaurantService restaurantService;

    @GetMapping
    public List<RestaurantDTO> getRestaurants() {
        return restaurantService.findAllRestaurants();
    }

    @PostMapping
    public RestaurantDTO addRestaurant(@RequestBody @Validated RestaurantDTO dto) {
        return restaurantService.addRestaurant(dto);
    }

    @GetMapping("{id}")
    public RestaurantDTO getRestaurant(@PathVariable("id") Long id) {
        return restaurantService.findRestaurantById(id);
    }

    @PutMapping
    public RestaurantDTO updateRestaurant(@RequestBody @Validated RestaurantDTO dto) {
        return restaurantService.updateRestaurant(dto);
    }

    @DeleteMapping("{id}")
    public void deleteRestaurant(@PathVariable("id") Long id) {
        restaurantService.deleteRestaurantById(id);
    }
}
