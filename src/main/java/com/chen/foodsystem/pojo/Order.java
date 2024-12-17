package com.chen.foodsystem.pojo;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class Order {
    private int orderId;
    private String userName;
    private String foodName;
    private int quantity;
    private double price;
    private Date orderdate;
    private String status;
    private int userId;
    private int foodId;
}