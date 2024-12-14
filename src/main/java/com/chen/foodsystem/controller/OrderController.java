package com.chen.foodsystem.controller;

import com.chen.foodsystem.pojo.Order;
import com.chen.foodsystem.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable int id) {
        return orderService.getOrderById(id);
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @PostMapping
    public String createOrder(@RequestBody Order order) {
        orderService.createOrder(order);
        return "Order created successfully!";
    }

    @PutMapping("/{id}")
    public String updateOrder(@PathVariable int id, @RequestBody Order order) {
        order.setOrderId(id);
        orderService.updateOrder(order);
        return "Order updated successfully!";
    }

    @DeleteMapping("/{id}")
    public String deleteOrder(@PathVariable int id) {
        orderService.deleteOrder(id);
        return "Order deleted successfully!";
    }
}
