package com.chen.foodsystem.service;

import com.chen.foodsystem.mapper.FoodMapper;
import com.chen.foodsystem.pojo.CartItem;
import com.chen.foodsystem.mapper.CartMapper;
import com.chen.foodsystem.pojo.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.QualifierAnnotationAutowireCandidateResolver;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartMapper cartMapper;

    // 添加一个食品
    public void addCartItem(int userID, int foodID, int quantity, double price, String foodName) {
        cartMapper.addCartItem(userID,foodID,quantity,price,foodName);
    }

    // 根据用户ID 查找 加入购物车的所有食品
    public List<CartItem> getCartItemByUserID(int userID){
        return cartMapper.getCartItemByUserID(userID);
    }

    public void removeAllCartItemByUserID(int userID){
        cartMapper.removeAllCartItemByUserID(userID);
    }

    public void removeCartItemByKey(int userID, int foodID){
        cartMapper.removeCartItemByKey(userID,foodID);
    }

    public void updateQuantityByKey(int userID, int foodID, int quantity) {
        cartMapper.updateQuantityByKey(userID, foodID, quantity);
    }
}
