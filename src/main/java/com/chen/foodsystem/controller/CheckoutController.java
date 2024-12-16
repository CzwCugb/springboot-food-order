package com.chen.foodsystem.controller;

import com.chen.foodsystem.pojo.CartItem;
import com.chen.foodsystem.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CheckoutController {

    @Autowired
    private CartService cartService;

    @RequestMapping("/checkout/{userID}")
    public String deleteAll(@PathVariable("userID") int userID, Model model){
        List<CartItem> CartItems = cartService.getCartItemByUserID(userID);
        model.addAttribute("totalPrice", CartController.getTotalPrice(CartItems));
        model.addAttribute("itemSum", CartController.getSumOfCartItems(CartItems));
        return "checkout";
    }
}
