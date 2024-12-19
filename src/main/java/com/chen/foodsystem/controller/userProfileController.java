package com.chen.foodsystem.controller;

import com.chen.foodsystem.pojo.User;
import com.chen.foodsystem.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/userProfile")  // 根路径 /userProfile
public class userProfileController {

    @Autowired
    private UserService userService;

    // 显示用户个人信息页面
    @GetMapping("/{userID}")
    public String showUserProfile(@PathVariable("userID") int userID, HttpSession session, Model model) {
        User loggedInUser = (User) session.getAttribute("loggedInUser");

        if (loggedInUser != null && loggedInUser.getUserID() == userID) {
            model.addAttribute("user", loggedInUser);
            return "user/userProfile"; // 渲染 userProfile.html
        } else {
            return "redirect:/login"; // 未登录或用户不匹配时重定向到登录页面
        }
    }

    // 处理用户信息更新请求
    @PostMapping("/update")
    public String updateUserProfile(@ModelAttribute("user") User user, HttpSession session, Model model) {
        try {
            // 更新用户信息
            userService.updateUser(user);
            session.setAttribute("loggedInUser", userService.getUserById(user.getUserID()));

            model.addAttribute("success", "个人信息修改成功");
        } catch (Exception e) {
            model.addAttribute("error", "修改失败，请稍后再试");
        }
        return "user/userProfile"; // 返回 userProfile.html
    }
}
