package com.chen.foodsystem.controller;

import com.chen.foodsystem.pojo.Food;
import com.chen.foodsystem.pojo.User;
import com.chen.foodsystem.service.OrderService;
import com.chen.foodsystem.service.UserService;
import com.github.pagehelper.PageHelper;
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
import org.springframework.web.bind.annotation.RequestParam;

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
        return "home";
    }

    // 获取商品列表（带分页）
    @RequestMapping("/{pageNum}")
    public String showIndexPage(@PathVariable("pageNum") int pageNum, Model model) {
        PageInfo<Food> pageInfo = foodService.getAllFoodPages(pageNum, 12);
        model.addAttribute("foodPage", pageInfo);  // 将分页数据传递给视图
        return "index";  // 返回食品列表视图
    }

    // 根据关键字模糊搜索商品
    @RequestMapping("/search")
    public String searchFoods(@RequestParam("foodName") String foodName,
                              @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                              Model model) {
        PageHelper.startPage(pageNum, 12);  // 分页，每页12条数据
        List<Food> foodList = foodService.getFoodsByFoodName(foodName);
        PageInfo<Food> pageInfo = new PageInfo<>(foodList);

        model.addAttribute("foodPage", pageInfo);
        model.addAttribute("searchKey", foodName); // 保存搜索关键字返回页面
        return "index";
    }

    @RequestMapping("/")
    public String showPageOne(HttpSession session) {
        User user = (User) session.getAttribute("loggedInUser");
        if(user != null && user.getRole().equals("管理员")) return "redirect:/admin/food/1";
        else return "redirect:/1";
    }

}
