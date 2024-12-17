package com.chen.foodsystem.service;

import com.chen.foodsystem.mapper.FoodMapper;
import com.chen.foodsystem.pojo.Food;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.RowBounds;
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

    // 获取分页的食品列表
    public PageInfo<Food> getAllFoodPages(int pageNum, int pageSize) {
        // 使用 PageHelper 来设置分页参数
        PageHelper.startPage(pageNum, pageSize);
        List<Food> foodList = foodMapper.findAllFoodPages();
        return new PageInfo<>(foodList);  // 返回分页结果
    }


    // 根据ID获取单个食品
    public Food getFoodById(int foodID) {
        return foodMapper.findFoodById(foodID);
    }

    public void updateFood(Food food) {
        foodMapper.updateFood(food);
    }
    // 添加新食品
    public void addFood(Food food) {
        foodMapper.insertFood(food);
    }

    // 更新食品信息

    // 删除食品
    public void deleteFood(int foodID) {
        foodMapper.deleteFood(foodID);
    }
}
