package com.chen.foodsystem.controller;

import com.chen.foodsystem.pojo.Food;
import com.chen.foodsystem.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/food")
public class FoodController {

    @Autowired
    private FoodService foodService;

    // 显示所有食品
    @GetMapping
    public String listAllFoods(Model model) {
        List<Food> foodList = foodService.getAllFoods();
        model.addAttribute("foodList", foodList);
        return "food/list";
    }

    // 显示添加食品表单
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("food", new Food());
        return "food/add";
    }

    // 处理添加食品请求
    @PostMapping("/add")
    public String addFood(@ModelAttribute Food food) {
        foodService.addFood(food);
        return "redirect:/food";
    }

    // 显示更新食品表单
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") int foodID, Model model) {
        Food food = foodService.getFoodById(foodID);
        model.addAttribute("food", food);
        return "food/edit";
    }

    // 处理更新食品请求
    @PostMapping("/edit")
    public String updateFood(@ModelAttribute Food food) {
        foodService.updateFood(food);
        return "redirect:/food";
    }

    // 处理删除食品请求
    @GetMapping("/delete/{id}")
    public String deleteFood(@PathVariable("id") int foodID) {
        foodService.deleteFood(foodID);
        return "redirect:/food";
    }
}