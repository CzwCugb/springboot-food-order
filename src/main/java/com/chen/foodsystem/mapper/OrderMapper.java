package com.chen.foodsystem.mapper;


import com.chen.foodsystem.pojo.Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface OrderMapper {

    List<Order> findOrdersByUsername(String username);

    List<Order> findOrderPagesByUsername(String username);

    List<Order> findAllOrderPages();

    List<Order> findAllOrders();

    List<Order> getOrdersByUserId(int userId);

    Order getOrderByOrderId(int orderId);

    void insertOrder(Order order);

    void updateOrder(Order order);

    void deleteOrder(Long orderId);



    Order getOrderById(Long orderId);

}
