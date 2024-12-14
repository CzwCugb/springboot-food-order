# 基于SpringBoot的网上订餐系统

## 作者

中国地质大学（北京）软件工程

陈志伟、周子豪、朱利康

## 工具 & 框架

开发环境：IDEA Utilmate 2025.2.3

框架：SpringBoot

数据库：MySQL

前端：Vue.js

## MAVEN依赖

```xml
<properties>
    <java.version>23</java.version>
</properties>

<dependencies>
    <dependency>
        <groupId>org.mybatis.spring.boot</groupId>
        <artifactId>mybatis-spring-boot-starter</artifactId>
        <version>3.0.3</version>
    </dependency>

    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>

    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-devtools</artifactId>
        <scope>runtime</scope>
        <optional>true</optional>
    </dependency>
    <dependency>
        <groupId>com.mysql</groupId>
        <artifactId>mysql-connector-j</artifactId>
        <scope>runtime</scope>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-configuration-processor</artifactId>
        <optional>true</optional>
    </dependency>
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <optional>true</optional>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>

    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-thymeleaf</artifactId>
    </dependency>

    <dependency>
        <groupId>org.thymeleaf</groupId>
        <artifactId>thymeleaf</artifactId>
        <version>3.1.2.RELEASE</version>
    </dependency>

    <dependency>
        <groupId>org.thymeleaf.extras</groupId>
        <artifactId>thymeleaf-extras-java8time</artifactId>
        <version>3.0.4.RELEASE</version>
    </dependency>
</dependencies>

```

## 功能 | 计划表

1：SpringBoot基础框架搭建 -- 12.13 --  Finish

2：数据库建表、Mybatis语句 -- 12.14 -- Finish

3：登录、注册（Ajax验证）-- TODO

4：展示页（show.html） -- TODO

5：详情页（details.html） -- TODO

6：购物车（cart.html） -- TODO

7：微信/支付宝支付 -- TODO

8：Vue框架重构网页 -- TODO

