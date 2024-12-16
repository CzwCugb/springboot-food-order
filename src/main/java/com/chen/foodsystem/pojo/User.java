package com.chen.foodsystem.pojo;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class User {
    private int userID;
    private String username;
    private String password;
    private String email;
    private String phone;
    private String role;
    private Date createdAt;
}