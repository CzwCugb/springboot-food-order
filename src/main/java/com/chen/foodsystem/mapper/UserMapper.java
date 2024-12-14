package com.chen.foodsystem.mapper;

import com.chen.foodsystem.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    User findByUsername(String username);

    List<User> findAllUsers();

    User findUserById(int userID);

    void insertUser(User user);

    void updateUser(User user);

    void deleteUser(int userID);
}
