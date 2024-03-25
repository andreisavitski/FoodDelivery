package by.pvt.fooddelivery.controller;

import by.pvt.fooddelivery.dto.RestaurantDTO;
import by.pvt.fooddelivery.logging.MethodLogging;
import by.pvt.fooddelivery.service.RestaurantService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/restaurant")
@RequiredArgsConstructor
@Tag(name = "RESTAURANT", description = "Allows you to manage restaurants")
public class RestaurantRestController {

    private final RestaurantService restaurantService;

    @Operation(summary = "Get all restaurants", security = @SecurityRequirement(name = "bearerAuth"))
    @MethodLogging
    @GetMapping
    public List<RestaurantDTO> getRestaurants() {
        return restaurantService.findAllRestaurants();
    }

    @Operation(summary = "Add a restaurant", security = @SecurityRequirement(name = "bearerAuth"))
    @MethodLogging
    @PostMapping
    public RestaurantDTO addRestaurant(@RequestBody @Validated RestaurantDTO dto) {
        return restaurantService.addRestaurant(dto);
    }

    @Operation(summary = "Get a restaurant by ID", security = @SecurityRequirement(name = "bearerAuth"))
    @MethodLogging
    @GetMapping("/{id}")
    public RestaurantDTO getRestaurant(@PathVariable("id") Long id) {
        return restaurantService.findRestaurantById(id);
    }

    @Operation(summary = "Change restaurant", security = @SecurityRequirement(name = "bearerAuth"))
    @MethodLogging
    @PutMapping
    public RestaurantDTO updateRestaurant(@RequestBody @Validated RestaurantDTO dto) {
        return restaurantService.updateRestaurant(dto);
    }

    @Operation(summary = "Delete restaurant", security = @SecurityRequirement(name = "bearerAuth"))
    @DeleteMapping("/{id}")
    public void deleteRestaurant(@PathVariable("id") Long id) {
        restaurantService.deleteRestaurantById(id);
    }
}
