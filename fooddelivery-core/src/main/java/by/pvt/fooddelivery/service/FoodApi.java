package by.pvt.fooddelivery.service;

import by.pvt.fooddelivery.domain.Food;

import java.util.List;

public interface FoodApi {
    void addFood(Food food);

    Food getFoodById(Long id);

    List<Food> gelAllFoods();

    void deleteFoodById(Long id);
}
