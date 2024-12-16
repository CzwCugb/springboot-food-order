package com.chen.foodsystem.pojo;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartItem {
    private int userID; // 用户 ID
    private int foodID; // 食品 ID
    private double price;  // 商品单价
    private int quantity;  // 商品数量
    private String foodName; // 商品名称
}