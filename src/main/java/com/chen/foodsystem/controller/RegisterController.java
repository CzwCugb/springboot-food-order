package com.chen.foodsystem.controller;

import com.chen.foodsystem.pojo.User;
import com.chen.foodsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class RegisterController {

    @Autowired
    UserService userService;

    @GetMapping("/register")
    public String showRegisterPage() {
        return "register";
    }

    @PostMapping("/register")
    public String register(@RequestParam String username,
                           @RequestParam String password,
                           @RequestParam String confirmPassword,
                           Model model) {


        List<User> userList = userService.getAllUsers();
        for (User user : userList) {
            if (user.getUsername().equals(username)) {
                model.addAttribute("error", "账号已经创建");
                return "register";
            }
        }
        if (!password.equals(confirmPassword)) {
            model.addAttribute("error", "两次输入的密码不一致");
            return "register";
        }
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        userService.addUser(user);
        return "redirect:/login";
    }
}