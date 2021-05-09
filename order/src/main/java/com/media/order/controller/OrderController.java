package com.media.order.controller;

import com.media.ObjectResponse;
import com.media.order.entity.Order;
import com.media.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description order api
 * @Author Hero
 * @Date 2021/5/7
 * @Version 1.0.0
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping("/create")
    public ObjectResponse<Order> createOrder(String userId , double ammount){
        return orderService.createOrder(userId , ammount);
    }
}
