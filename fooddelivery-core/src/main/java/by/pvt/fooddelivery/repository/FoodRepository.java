package by.pvt.fooddelivery.repository;

import by.pvt.fooddelivery.domain.Food;

import java.util.List;
import java.util.Optional;

public interface FoodRepository {
    void addFood(Food food);

    Optional<Food> getFoodById(Long foodId);

    List<Food> gelAllFoods();

    void deleteFoodById(Long foodId);

    List<Food> getFoodsByName(String foodName);

    List<Food> getFoodsByFoodNameAndRestaurantName(String foodName, String restaurantName);

    List<Food> getFoodsByRestaurantName(String restaurantName);

    List<Food> getFoodsByRestaurantId(Long restaurantId);

    void updateFood(Food food);
}
