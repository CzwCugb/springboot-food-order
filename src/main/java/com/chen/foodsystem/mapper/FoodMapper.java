package com.chen.foodsystem.mapper;

import com.chen.foodsystem.pojo.Food;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FoodMapper {

    List<Food> findAllFoods();

    Food findFoodById(int foodID);

    void insertFood(Food food);

    void updateFood(Food food);

    void deleteFood(int foodID);
}