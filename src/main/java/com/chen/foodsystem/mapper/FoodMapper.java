package com.chen.foodsystem.mapper;

import com.chen.foodsystem.pojo.Food;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FoodMapper {

    List<Food> findAllFoods();

    List<Food> findAllFoodPages();

    List<Food> findFoodsByFoodName(String foodName);

    List<Food> findFoodPagesByFoodName(String foodName);

    Food findFoodById(int foodID);

    void insertFood(Food food);

    void updateFood(Food food);

    void deleteFood(int foodID);

    List<Food> findFoodByName(String name);
}