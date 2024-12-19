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
import com.chen.foodsystem.utils.AESUtil; // 引入解密工具类
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;


    @GetMapping("/login")
    public String showLoginPage(HttpSession session) {
        return "login";
    }

    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<?> login(@RequestParam String username,
                                   @RequestParam String password,
                                   HttpSession session) {
        //System.out.println("接收到的加密用户名: " + username);
        //System.out.println("接收到的加密密码: " + password);
        try {
            String key = "secureKey1234567"; // 16字节密钥

            // 解密接收到的用户名和密码
            String decryptedUsername = AESUtil.decrypt(username, key);
            String decryptedPassword = AESUtil.decrypt(password, key);

            // 数据库校验
            User user = userService.findByUsername(decryptedUsername);
            if (user == null || !user.getPassword().equals(decryptedPassword)) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("用户名或密码错误");
            }

            // 保存登录状态
            session.setAttribute("loggedInUser", user);
            return ResponseEntity.ok("登录成功");

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("服务器错误，请稍后重试");
        }
    }

    // 处理用户登出请求
    @GetMapping("/login/logout")
    public String logout(HttpSession session) {
        // 清除 Session 中的用户信息
        session.removeAttribute("loggedInUser");
        return "redirect:/";
    }
}