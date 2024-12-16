package com.chen.foodsystem.controller;


import com.chen.foodsystem.pojo.Food;
import com.chen.foodsystem.service.CartService;
import com.chen.foodsystem.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DetailsController {

    @Autowired
    private FoodService foodService;
    @Autowired
    private CartService cartService;

    @PostMapping("/cart/add/{userID}/{foodID}/{quantity}")
    public String addToCart(@PathVariable("userID") int userID,
                            @PathVariable("foodID") int foodID,
                            @PathVariable("quantity") int quantity) {
        // 获取食品信息
        Food food = foodService.getFoodById(foodID);
        cartService.addCartItem(userID, foodID, quantity, food.getPrice(), food.getName());
        return "redirect:/";
    }

}
