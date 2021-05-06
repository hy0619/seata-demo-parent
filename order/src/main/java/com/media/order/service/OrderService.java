package com.media.order.service;

import com.media.order.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import response.ObjectResponse;

import java.util.UUID;

@Service
public class OrderService {

    public final static String ACCOUNT_SERVICE = "http://localhost:81/account/";
    @Autowired
    RestTemplate restTemplate;
    
    OrderMapper orderMapper;

    public ObjectResponse createOrder(String userId , double ammount ){
        ObjectResponse objectResponse =
                restTemplate.getForObject(ACCOUNT_SERVICE + userId + "/" + ammount
                , ObjectResponse.class);


        Order order = new Order().setOrderNo(UUID.randomUUID().toString())
                .setAmount(ammount).setCount(1)
                .setCommodityCode("commonditycode").setUserId(userId);
        





    }
}
