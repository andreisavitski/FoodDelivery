package by.pvt.fooddelivery.service.impl;

import by.pvt.fooddelivery.dto.RestaurantDTO;
import by.pvt.fooddelivery.mapper.RestaurantMapper;
import by.pvt.fooddelivery.repository.RestaurantRepository;
import by.pvt.fooddelivery.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final RestaurantMapper restaurantMapper;

    @Override
    @Transactional
    public RestaurantDTO addRestaurant(RestaurantDTO restaurantDTO) {
        return restaurantMapper.toDTO(restaurantRepository.save(restaurantMapper.toRestaurant(restaurantDTO)));
    }

    @Override
    @Transactional
    public void deleteRestaurantById(Long restaurantId) {
        restaurantRepository.deleteById(restaurantId);
    }

    @Override
    public RestaurantDTO findRestaurantById(Long restaurantId) {
        return restaurantMapper.toDTO(restaurantRepository.findById(restaurantId).orElseThrow(() -> new RuntimeException("Restaurant does not exist")));
    }

    @Override
    public List<RestaurantDTO> findAllRestaurants() {
        return restaurantRepository.findAll().stream().map(restaurantMapper::toDTO).toList();
    }

    @Override
    @Transactional
    public RestaurantDTO updateRestaurant(RestaurantDTO restaurantDTO) {
        return restaurantMapper.toDTO(restaurantRepository.save(restaurantMapper.toRestaurant(restaurantDTO)));
    }
}
