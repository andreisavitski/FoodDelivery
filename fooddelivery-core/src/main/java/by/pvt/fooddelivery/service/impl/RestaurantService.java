package by.pvt.fooddelivery.service.impl;

import by.pvt.fooddelivery.dto.RestaurantDTO;
import by.pvt.fooddelivery.mapper.RestaurantMapper;
import by.pvt.fooddelivery.repository.RestaurantRepository;
import by.pvt.fooddelivery.service.RestaurantApi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantService implements RestaurantApi {
    private final RestaurantRepository restaurantRepository;
    private final RestaurantMapper restaurantMapper;

    @Override
    public void addRestaurant(RestaurantDTO restaurantDTO) {
        restaurantRepository.addRestaurant(restaurantMapper.toRestaurant(restaurantDTO));
    }

    @Override
    public RestaurantDTO getRestaurantById(Long restaurantId) {
        return restaurantMapper.toDTO(restaurantRepository.getRestaurantById(restaurantId).orElseThrow(
                () -> new RuntimeException("Restaurant does not exist")));
    }

    @Override
    public List<RestaurantDTO> getAllRestaurants() {
        return restaurantRepository.getAllRestaurants().stream().map(restaurantMapper::toDTO).toList();
    }

    @Override
    public void deleteRestaurantById(Long restaurantId) {
        restaurantRepository.deleteRestaurantById(restaurantId);
    }

    @Override
    public void updateRestaurant(RestaurantDTO restaurantDTO) {
        restaurantRepository.updateRestaurant(restaurantMapper.toRestaurant(restaurantDTO));
    }
}
