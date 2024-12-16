package com.chen.foodsystem.mapper;

import com.chen.foodsystem.pojo.CartItem;
import com.chen.foodsystem.pojo.Food;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CartMapper {

    void addCartItem(int userID, int foodID, double quantity, double price, String foodName);

    List<CartItem> getCartItemByUserID(int userID);

    void removeAllCartItemByUserID(int userID);

    void removeCartItemByKey(int userID, int foodID);

    void updateQuantityByKey(int userID, int foodID, int quantity);

}
