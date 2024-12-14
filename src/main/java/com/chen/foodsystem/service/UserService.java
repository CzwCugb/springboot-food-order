package com.chen.foodsystem.service;


import com.chen.foodsystem.mapper.UserMapper;
import com.chen.foodsystem.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    // 根据用户名查找用户
    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    // 获取所有用户
    public List<User> getAllUsers() {
        return userMapper.findAllUsers();
    }

    // 根据ID获取单个用户
    public User getUserById(int userID) {
        return userMapper.findUserById(userID);
    }

    // 添加新用户
    public void addUser(User user) {
        userMapper.insertUser(user);
    }

    // 更新用户信息
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    // 删除用户
    public void deleteUser(int userID) {
        userMapper.deleteUser(userID);
    }
}