package com.chen.foodsystem.mapper;

import com.chen.foodsystem.pojo.Food;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

@Mapper
public interface FoodMapper {

    List<Food> findAllFoods();

    List<Food> findAllFoodPages();

    Food findFoodById(int foodID);

    void insertFood(Food food);

    void updateFood(Food food);

    void deleteFood(int foodID);
}