package by.pvt.fooddelivery.service.impl;

import by.pvt.fooddelivery.dto.RestaurantDTO;
import by.pvt.fooddelivery.exception.ApplicationException;
import by.pvt.fooddelivery.mapper.RestaurantMapper;
import by.pvt.fooddelivery.repository.RestaurantRepository;
import by.pvt.fooddelivery.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static by.pvt.fooddelivery.exception.ApplicationError.RESTAURANT_NOT_ADDED;
import static by.pvt.fooddelivery.exception.ApplicationError.RESTAURANT_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final RestaurantMapper restaurantMapper;

    @Override
    @Transactional
    public RestaurantDTO addRestaurant(RestaurantDTO restaurantDTO) {
        return restaurantMapper.toDTO(restaurantRepository.save(restaurantMapper.toRestaurant(checkingUniqueName(restaurantDTO))));
    }

    @Override
    @Transactional
    public void deleteRestaurantById(Long restaurantId) {
        restaurantRepository.delete(restaurantMapper.toRestaurant(findRestaurantById(restaurantId)));
    }

    @Override
    public RestaurantDTO findRestaurantById(Long restaurantId) {
        return restaurantMapper.toDTO(restaurantRepository.findById(restaurantId).orElseThrow(() -> new ApplicationException(RESTAURANT_NOT_FOUND)));
    }

    @Override
    public List<RestaurantDTO> findAllRestaurants() {
        List<RestaurantDTO> restaurants = restaurantRepository.findAll().stream().map(restaurantMapper::toDTO).toList();
        if (restaurants.isEmpty()) {
            throw new ApplicationException(RESTAURANT_NOT_FOUND);
        }
        return restaurants;
    }

    @Override
    @Transactional
    public RestaurantDTO updateRestaurant(RestaurantDTO restaurantDTO) {
        findRestaurantById(restaurantDTO.getId());
        return restaurantMapper.toDTO(restaurantRepository.save(restaurantMapper.toRestaurant(checkingUniqueName(restaurantDTO))));
    }

    private RestaurantDTO checkingUniqueName(RestaurantDTO restaurantDTO) {
        if (!restaurantRepository.findAll().stream().filter(restaurant -> restaurant.getName().equals(restaurantDTO.getName())).toList().isEmpty()) {
            throw new ApplicationException(RESTAURANT_NOT_ADDED);
        }
        return restaurantDTO;
    }
}
