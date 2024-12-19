package com.chen.foodsystem.controller;

import com.chen.foodsystem.pojo.Food;
import com.chen.foodsystem.pojo.Order;
import com.chen.foodsystem.pojo.User;
import com.chen.foodsystem.service.FoodService;
import com.chen.foodsystem.service.OrderService;
import com.chen.foodsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private FoodService foodService;

    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    @GetMapping("/{pageType}/{pageNum}")
    public String showAdminPage(@PathVariable("pageType") String pageType,
                                @PathVariable("pageNum") int pageNum,
                                Model model) {
        model.addAttribute("page", pageType);
        switch (pageType) {
            case "food":
                model.addAttribute("foodPage", foodService.getAllFoodPages(pageNum,12));
                return "admin/adminFood";
            case "user":
                model.addAttribute("userPage", userService.getAllUserPages(pageNum,12));
                return "admin/adminUser";
            case "order":
                model.addAttribute("orderPage", orderService.getAllOrderPages(pageNum,12));
                return "admin/adminOrder";
            default:
                return "admin/adminFood";
        }
    }
    @GetMapping("/{pageType}")
    public String showAdminPage(@PathVariable("pageType") String pageType) {
        return "redirect:/admin/" + pageType + "/1";
    }

    @GetMapping("/food/search/{pageNum}")
    public String showFoodPage(@RequestParam(value = "name", required = false) String name,
                               @PathVariable("pageNum") int pageNum,
                               Model model) {
        if (name != null && !name.trim().isEmpty()) {
            model.addAttribute("foodPage", foodService.searchFoodPagesByName(pageNum,12,name));
            model.addAttribute("searchName", name);
        } else {
            return "redirect:/admin/food";
        }
        return "admin/adminFood";
    }

    @GetMapping("/food/create")
    public String showCreateFoodForm(Model model) {
        model.addAttribute("food", new Food());
        return "admin/createFood";
    }

    @PostMapping("/food/create")
    public String createFood(@ModelAttribute Food food) {
        foodService.addFood(food);
        return "redirect:/admin/food";
    }

    @GetMapping("/food/edit/{id}")
    public String showEditFoodForm(@PathVariable("id") int foodID, Model model) {
        Food food = foodService.getFoodById(foodID);
        if (food != null) {
            model.addAttribute("food", food);
        }
        return "admin/editFood";
    }

    @PostMapping("/food/edit")
    public String editFood(@ModelAttribute Food food) {
        foodService.updateFood(food);
        return "redirect:/admin/food";
    }

    @GetMapping("/food/delete/{id}")
    public String deleteFood(@PathVariable("id") int foodID) {
        foodService.deleteFood(foodID); // 删除指定菜品
        return "redirect:/admin/food"; // 返回菜品管理页面
    }


    @GetMapping("/user/search/{pageNum}")
    public String showUserPage(@RequestParam(value = "username", required = false) String username,
                               @PathVariable("pageNum") int pageNum,
                               Model model) {
        if (username != null && !username.trim().isEmpty()) {
            model.addAttribute("userPage",userService.searchUserPagesByUsername(pageNum,12,username));
            model.addAttribute("searchName", username);
        } else {
            return "redirect:/admin/user";
        }
        return "admin/adminUser";
    }

    @GetMapping("/user/edit/{id}")
    public String showEditUserForm(@PathVariable("id") int userID, Model model) {
        User user = userService.getUserById(userID);
        model.addAttribute("user", user);
        return "admin/editUser";
    }

    @PostMapping("/user/edit")
    public String editUser(@ModelAttribute User user) {
        userService.updateUser(user);
        return "redirect:/admin/user";
    }

    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id") int userID) {
        userService.deleteUser(userID);
        return "redirect:/admin/user";
    }


    @GetMapping("/order/edit/{id}")
    public String showEditOrderForm(@PathVariable("id") Long orderID, Model model) {
        Order order = orderService.getOrderById(orderID);
        if (order == null) {
            // 如果订单不存在，重定向到订单管理页面
            return "redirect:/admin/order?error=OrderNotFound";
        }
        model.addAttribute("order", order);
        return "admin/editOrder"; // 返回视图模板 "editOrder.html"
    }

    @GetMapping("/order/search/{pageNum}")
    public String showOrderPage(@RequestParam(value = "username", required = false) String username,
                                @PathVariable("pageNum") int pageNum,
                                Model model) {
        if (username != null && !username.trim().isEmpty()) {
            model.addAttribute("orderPage",orderService.searchOrderPagesByUsername(pageNum,12,username));
            model.addAttribute("searchName", username);
        } else {
            return "redirect:/admin/order";
        }
        return "admin/adminOrder";
    }

    @PostMapping("/order/update")
    public String updateOrder(@ModelAttribute Order order) {
        try {
            orderService.updateOrder(order);
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/admin/order?error=UpdateFailed";
        }
        return "redirect:/admin/order";
    }

    @GetMapping("/order/delete/{id}")
    public String deleteOrder(@PathVariable("id") Long orderID) {
        orderService.deleteOrder(orderID);
        return "redirect:/admin/order";
    }
}