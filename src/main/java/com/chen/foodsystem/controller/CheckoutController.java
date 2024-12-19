package com.chen.foodsystem.controller;

import com.chen.foodsystem.pojo.CartItem;
import com.chen.foodsystem.pojo.Order;
import com.chen.foodsystem.service.CartService;
import com.chen.foodsystem.service.OrderService;
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
    @Autowired
    private OrderService orderService;

    @RequestMapping("/checkout/{userID}")
    public String showCheckoutPage(@PathVariable("userID") int userID, Model model) {
        List<CartItem> CartItems = cartService.getCartItemByUserID(userID);
        model.addAttribute("userId", userID);
        model.addAttribute("totalPrice", CartController.getTotalPrice(CartItems));
        model.addAttribute("itemSum", CartController.getSumOfCartItems(CartItems));
        return "user/checkout";
    }

    @RequestMapping({"/checkout/{userID}/wechat","/checkout/{userID}/alipay"})
    public String wechatPay(@PathVariable("userID") int userID, Model model) {

        List<CartItem> CartItems = cartService.getCartItemByUserID(userID);
        Order order = new Order();
        for(CartItem cartItem : CartItems) {
            order.setUserId(cartItem.getUserID());
            order.setFoodId(cartItem.getFoodID());
            order.setFoodName(cartItem.getFoodName());
            order.setQuantity(cartItem.getQuantity());
            order.setPrice(cartItem.getPrice());
            orderService.createOrder(order);
        }
        cartService.removeAllCartItemByUserID(userID);
        return "user/checkout";
    }

}
