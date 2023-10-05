package by.pvt.fooddelivery.service;

import by.pvt.fooddelivery.domain.Food;

import java.util.List;

public interface FoodApi {
    void addFood(Food food);

    Food getFoodById(Long foodId);

    List<Food> gelAllFoods();

    void deleteFoodById(Long foodId);

    List<Food> getFoodsByName(String foodName);

    List<Food> getFoodsByRestaurantName(String restaurantName);

    List<Food> getFoodsByRestaurantId(Long restaurantId);

    void updateFood(Food food);

    List<Food> getFoodsByFoodNameAndRestaurantName(String foodName, String restaurantName);
}
