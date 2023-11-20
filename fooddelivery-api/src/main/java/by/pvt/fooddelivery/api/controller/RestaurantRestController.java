package by.pvt.fooddelivery.api.controller;

import by.pvt.fooddelivery.dto.RestaurantDTO;
import by.pvt.fooddelivery.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
@RequiredArgsConstructor
public class RestaurantRestController {
    private final RestaurantService restaurantService;

    @GetMapping("/getAll")
    public List<RestaurantDTO> getRestaurants() {
        return restaurantService.findAllRestaurants();
    }


    @PostMapping("/addRestaurant")
    public RestaurantDTO addRestaurant(@RequestBody RestaurantDTO dto) {
        return restaurantService.addRestaurant(dto);
    }

    @GetMapping("/getRestaurant/{id}")
    public RestaurantDTO getRestaurant(@PathVariable("id") Long id) {
        return restaurantService.findRestaurantById(id);
    }

    @PutMapping("/updateRestaurant")
    public RestaurantDTO updateRestaurant(@RequestBody RestaurantDTO dto) {
        return restaurantService.updateRestaurant(dto);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public void deleteRestaurant(@PathVariable("id") Long id) {
        restaurantService.deleteRestaurantById(id);
    }
}
