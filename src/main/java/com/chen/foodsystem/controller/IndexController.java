package com.chen.foodsystem.controller;

import com.chen.foodsystem.pojo.Food;
import com.chen.foodsystem.service.OrderService;
import com.chen.foodsystem.service.UserService;
import com.github.pagehelper.PageInfo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.chen.foodsystem.service.FoodService;

import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private FoodService foodService;

    @Autowired
    private OrderService orderService;

    // 跳转详情页
    @GetMapping("/food/{foodID}")
    public String getFoodDetails(@PathVariable("foodID") int id, Model model) {
        // 获取指定ID的食品
        Food food = foodService.getFoodById(id);
        model.addAttribute("food", food);
        return "details"; // 返回食品详情页面
    }

    // 跳转订单页
    @RequestMapping("/home/{userID}")
    public String showHomePage(@PathVariable("userID") int userId, Model model) {
        model.addAttribute("orders", orderService.getOrdersByUserId(userId));
        System.out.println("success");
        return "home";
    }


    // 获取商品列表
    @RequestMapping("/debug-unuse")
    public String showIndexPage(Model model, HttpSession session) {
        List<Food> foodList = foodService.getAllFoods();
        model.addAttribute("foodList", foodList);

        // debug 设置为管理员
        // session.setAttribute("loggedInUser", userService.findByUsername("admin"));
        //return "redirect:/admin/foods/";
        // 默认：
        return "index";
    }

    // 获取商品列表（带分页）
    @RequestMapping("/{pageNum}")
    public String showIndexPage(@PathVariable("pageNum") int pageNum, Model model) {
        PageInfo<Food> pageInfo = foodService.getAllFoodPages(pageNum, 12);
        model.addAttribute("foodPage", pageInfo);  // 将分页数据传递给视图
        return "index";  // 返回食品列表视图
    }

    @RequestMapping("/")
    public String showPageOne() {
        return "redirect:/1";
    }

}
