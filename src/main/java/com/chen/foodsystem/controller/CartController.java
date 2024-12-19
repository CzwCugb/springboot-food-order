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
public class CartController {

    @Autowired
    private CartService cartService;

    // 显示购物车
    @RequestMapping("/cart/{userID}")
    public String showCart(@PathVariable("userID") int userID, Model model) {
        List<CartItem> cartItems = cartService.getCartItemByUserID(userID);
        model.addAttribute("cartItems", cartItems);
        model.addAttribute("totalPrice", getTotalPrice(cartItems));
        return "user/cart";
    }

    @RequestMapping("/cart/{userID}/deleteAll")
    public String deleteAll(@PathVariable("userID") int userID){
        cartService.removeAllCartItemByUserID(userID);
        return "redirect:/cart/"+userID;
    }

    @RequestMapping("/cart/remove/{userID}/{foodID}")
    public String deleteAll(@PathVariable("userID") int userID,
                            @PathVariable("foodID") int foodID){
        cartService.removeCartItemByKey(userID, foodID);
        return "redirect:/cart/"+userID;
    }

    @RequestMapping("/cart/updateQuantity/{userID}/{foodID}/{quantity}")
    public String deleteAll(@PathVariable("userID") int userID,
                            @PathVariable("foodID") int foodID,
                            @PathVariable("quantity") int quantity){
        cartService.updateQuantityByKey(userID, foodID, quantity);
        return "redirect:/cart/"+userID;
    }


    static public double getTotalPrice(List<CartItem> cartItems){
        double result = 0;
        for(CartItem cartItem : cartItems){
            result += cartItem.getPrice()*cartItem.getQuantity();
        }
        return result;
    }

    static public int getSumOfCartItems(List<CartItem> cartItems){
        int result = 0;
        for(CartItem cartItem : cartItems){
            result += cartItem.getQuantity();
        }
        return result;
    }

}
