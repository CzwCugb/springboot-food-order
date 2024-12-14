package com.chen.foodsystem.controller;

import com.chen.foodsystem.pojo.User;
import com.chen.foodsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // 显示所有用户
    @GetMapping
    public String listAllUsers(Model model) {
        List<User> userList = userService.getAllUsers();
        model.addAttribute("userList", userList);
        return "user/list";
    }

    // 显示添加用户表单
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("user", new User());
        return "user/add";
    }

    // 处理添加用户请求
    @PostMapping("/add")
    public String addUser(@ModelAttribute User user) {
        userService.addUser(user);
        return "redirect:/users";
    }

    // 显示更新用户表单
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") int userID, Model model) {
        User user = userService.getUserById(userID);
        model.addAttribute("user", user);
        return "user/edit";
    }

    // 处理更新用户请求
    @PostMapping("/edit")
    public String updateUser(@ModelAttribute User user) {
        userService.updateUser(user);
        return "redirect:/users";
    }

    // 处理删除用户请求
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int userID) {
        userService.deleteUser(userID);
        return "redirect:/users";
    }
}