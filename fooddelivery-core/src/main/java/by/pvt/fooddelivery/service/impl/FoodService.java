package by.pvt.fooddelivery.service.impl;

import by.pvt.fooddelivery.dao.FoodDAO;
import by.pvt.fooddelivery.domain.Food;
import by.pvt.fooddelivery.service.FoodApi;

import java.util.List;

public class FoodService implements FoodApi {
    private final FoodDAO foodDAO;

    public FoodService(FoodDAO foodDAO) {
        this.foodDAO = foodDAO;
    }

    @Override
    public void addFood(Food food) {
        foodDAO.addFood(food);
    }

    @Override
    public Food getFoodById(Long id) {
        return foodDAO.getFoodById(id);
    }

    @Override
    public List<Food> gelAllFoods() {
        return foodDAO.gelAllFoods();
    }

    @Override
    public void deleteFoodById(Long id) {
        foodDAO.deleteFoodById(id);
    }
}
