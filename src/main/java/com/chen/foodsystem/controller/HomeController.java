package com.chen.foodsystem.controller;


import com.chen.foodsystem.pojo.Order;
import com.chen.foodsystem.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @Autowired
    private OrderService orderService;

    // 取消订单
    @RequestMapping("/home/{userId}/{orderId}/cancel")
    public String cancelOrder(Model model, @PathVariable int userId, @PathVariable int orderId) {
        Order order = orderService.getOrderByOrderId(orderId);
        order.setStatus("已撤销");
        orderService.updateOrder(order);
        return "redirect:/home/" + userId;
    }

    // 删除订单
    @RequestMapping("/home/{userId}/{orderId}/delete")
    public String deleteOrder(Model model, @PathVariable int userId, @PathVariable int orderId) {
        Order order = orderService.getOrderByOrderId(orderId);
        order.setStatus("已完成");
        orderService.updateOrder(order);
        return "redirect:/home/" + userId;
    }

}
