package com.chen.foodsystem;

import com.alibaba.druid.pool.DruidDataSource;
import com.chen.foodsystem.pojo.CartItem;
import com.chen.foodsystem.pojo.User;
import com.chen.foodsystem.service.CartService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

@SpringBootTest
class FoodSystemApplicationTests {

    @Autowired
    CartService cartService;

    @Resource
    private DataSource dataSource;

    @Test
    void testCart() {
        List<CartItem> l = cartService.getCartItemByUserID(1);
        for(CartItem ci : l){
            System.out.println(ci.getFoodName());
        }
    }

    @Test
    void testDataSource(){
        DruidDataSource druidDataSource = (DruidDataSource) dataSource;
        System.out.println(druidDataSource.getDriverClassName());
        System.out.println(druidDataSource.getUrl());
        System.out.println(druidDataSource.getUsername());
        System.out.println(druidDataSource.getPassword());
    }

}
