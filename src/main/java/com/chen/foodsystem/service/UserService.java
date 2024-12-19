package com.chen.foodsystem.service;


import com.chen.foodsystem.mapper.UserMapper;
import com.chen.foodsystem.pojo.Food;
import com.chen.foodsystem.pojo.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    // 查找全部用户 不分页
    public List<User> getAllUsers() {
        return userMapper.findAllUsers();
    }

    // 查找全部用户 分页
    public PageInfo<User> getAllUserPages(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> userList = userMapper.findAllUserPages();
        return new PageInfo<>(userList);
    }

    // 通过名字模糊查找 用户 不分页
    public List<User> searchUsersByUsername(String username) {
        return userMapper.findUsersByUsername(username);
    }

    // 通过名字模糊查找 用户 分页
    public PageInfo<User> searchUserPagesByUsername(int pageNum, int pageSize, String username){
        PageHelper.startPage(pageNum, pageSize);
        List<User> userList = userMapper.findUserPagesByUsername(username);
        return new PageInfo<>(userList);  // 返回分页结果
    }

    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    public User findUserByExactUsername(String username) {
        return userMapper.findUserByExactUsername(username);
    }

    public PageInfo<User> findUserPagesByUsername(int pageNum, int pageSize, String username) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> userList = userMapper.findUserPagesByUsername(username);
        return new PageInfo<>(userList);
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