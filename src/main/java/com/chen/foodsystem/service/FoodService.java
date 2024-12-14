package com.chen.foodsystem.service;


import com.chen.foodsystem.mapper.FoodMapper;
import com.chen.foodsystem.pojo.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {

    @Autowired
    private FoodMapper foodMapper;

    // 获取所有食品
    public List<Food> getAllFoods() {
        return foodMapper.findAllFoods();
    }

    // 根据ID获取单个食品
    public Food getFoodById(int foodID) {
        return foodMapper.findFoodById(foodID);
    }

    // 添加新食品
    public void addFood(Food food) {
        foodMapper.insertFood(food);
    }

    // 更新食品信息
    public void updateFood(Food food) {
        foodMapper.updateFood(food);
    }

    // 删除食品
    public void deleteFood(int foodID) {
        foodMapper.deleteFood(foodID);
    }
}
