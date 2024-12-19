package com.chen.foodsystem.service;

import com.chen.foodsystem.mapper.OrderMapper;
import com.chen.foodsystem.pojo.Food;
import com.chen.foodsystem.pojo.Order;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;


    // 查找全部订单 不分页
    public List<Order> getAllOrders() {
        return orderMapper.findAllOrders();
    }

    // 查找全部订单 分页
    public PageInfo<Order> getAllOrderPages(int pageNum, int pageSize) {
        // 使用 PageHelper 来设置分页参数
        PageHelper.startPage(pageNum, pageSize);
        List<Order> orderList = orderMapper.findAllOrderPages();
        return new PageInfo<>(orderList);  // 返回分页结果
    }

    // 通过名字模糊查找 订单 不分页
    public List<Order> searchOrdersByUsername(String username) {
        return orderMapper.findOrdersByUsername(username);
    }

    // 通过名字模糊查找 订单 分页
    public PageInfo<Order> searchOrderPagesByUsername(int pageNum, int pageSize, String username) {
        PageHelper.startPage(pageNum, pageSize);
        List<Order> orderList = orderMapper.findOrderPagesByUsername(username);
        return new PageInfo<>(orderList);
    }


    public List<Order> getOrdersByUserId(int userId) {
        return orderMapper.getOrdersByUserId(userId);
    }

    public Order getOrderByOrderId(int orderId){
        return orderMapper.getOrderByOrderId(orderId);
    }

    public Order getOrderById(Long id) {
        return orderMapper.getOrderById(id);
    }


    public void createOrder(Order order) {
        orderMapper.insertOrder(order);
    }

    public void updateOrder(Order order) {
        orderMapper.updateOrder(order);
    }

    public void deleteOrder(Long id) {
        orderMapper.deleteOrder(id);
    }


}