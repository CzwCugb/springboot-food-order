package com.chen.foodsystem.controller;

import com.chen.foodsystem.pojo.User;
import com.chen.foodsystem.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    // 显示登录页面
    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    // 处理登录请求
    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        Model model,
                        HttpSession session) {

        User user = userService.findByUsername(username);

        // 验证密码
        if (user == null || !user.getPassword().equals(password)) {
            model.addAttribute("error", "用户名或密码错误");
            return "login";
        }

        // 将用户信息保存到 Session 中，表示登录状态
        session.setAttribute("loggedInUser", user);

        // 登录成功后重定向到首页
        return "redirect:/";
    }

    // 处理用户登出请求
    @GetMapping("/login/logout")
    public String logout(HttpSession session) {
        // 清除 Session 中的用户信息
        session.removeAttribute("loggedInUser");
        return "redirect:/";
    }
}