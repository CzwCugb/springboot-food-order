package com.chen.foodsystem.pojo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Food {
    private int foodID;
    private String name;
    private String description;
    private double price;
    private String image;
    private boolean available;
}
