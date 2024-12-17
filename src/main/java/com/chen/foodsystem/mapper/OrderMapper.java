package com.chen.foodsystem.mapper;


import com.chen.foodsystem.pojo.Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface OrderMapper {

    List<Order> getOrdersByUserId(int userId);

    Order getOrderByOrderId(int orderId);

    List<Order> getAllOrders();

    void insertOrder(Order order);

    void updateOrder(Order order);

    void deleteOrder(int orderId);

}
