package com.chen.foodsystem.controller;

import com.chen.foodsystem.pojo.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.chen.foodsystem.service.FoodService;

import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private FoodService foodService;

    @GetMapping("/food/{foodID}")
    public String getFoodDetails(@PathVariable("foodID") int id, Model model) {
        // 获取指定ID的食品
        Food food = foodService.getFoodById(id);
        model.addAttribute("food", food);
        return "details"; // 返回食品详情页面
    }

    // 获取商品列表
    @RequestMapping("/")
    public String showIndexPage(Model model){
        List<Food> foodList = foodService.getAllFoods();
        model.addAttribute("foodList", foodList);
        return "index";
    }

}
