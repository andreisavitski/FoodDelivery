package by.pvt.fooddelivery.service.impl;

import by.pvt.fooddelivery.domain.Food;
import by.pvt.fooddelivery.repository.FoodRepository;
import by.pvt.fooddelivery.service.FoodApi;

import java.util.List;

public class FoodService implements FoodApi {
    private final FoodRepository foodRepository;

    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    @Override
    public void addFood(Food food) {
        foodRepository.addFood(food);
    }

    @Override
    public Food getFoodById(Long foodId) {
        return foodRepository.getFoodById(foodId).orElseThrow(
                () -> new RuntimeException("Food does not exist"));
    }

    @Override
    public List<Food> gelAllFoods() {
        return foodRepository.gelAllFoods();
    }

    @Override
    public void deleteFoodById(Long foodId) {
        foodRepository.deleteFoodById(foodId);
    }

    @Override
    public List<Food> getFoodsByName(String foodName) {
        return foodRepository.getFoodsByName(foodName);
    }

    @Override
    public List<Food> getFoodsByRestaurantName(String restaurantName) {
        return foodRepository.getFoodsByRestaurantName(restaurantName);
    }

    @Override
    public List<Food> getFoodsByRestaurantId(Long restaurantId) {
        return foodRepository.getFoodsByRestaurantId(restaurantId);
    }

    @Override
    public void updateFood(Food food) {
        foodRepository.updateFood(food);
    }
}
