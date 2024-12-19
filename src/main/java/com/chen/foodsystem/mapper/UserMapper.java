package com.chen.foodsystem.mapper;

import com.chen.foodsystem.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    // 精确查询用户
    User findUserByExactUsername(@Param("username") String username);


    // 查找全部用户 不分页
    List<User> findAllUsers();

    // 查找全部用户 分页
    List<User> findAllUserPages();

    // 模糊查询用户 不分页
    List<User> findUsersByUsername(String username);

    // 模糊查询用户 分页
    List<User> findUserPagesByUsername(String username);


    User findByUsername(String username);

    User findUserById(int userID);

    void insertUser(User user);

    void updateUser(User user);

    void deleteUser(int userID);
}
