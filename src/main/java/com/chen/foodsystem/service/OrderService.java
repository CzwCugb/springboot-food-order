package com.chen.foodsystem.service;

import com.chen.foodsystem.mapper.OrderMapper;
import com.chen.foodsystem.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

    public Order getOrderById(int id) {
        return orderMapper.getOrderById(id);
    }

    public List<Order> getAllOrders() {
        return orderMapper.getAllOrders();
    }

    public void createOrder(Order order) {
        orderMapper.insertOrder(order);
    }

    public void updateOrder(Order order) {
        orderMapper.updateOrder(order);
    }

    public void deleteOrder(int id) {
        orderMapper.deleteOrder(id);
    }
}