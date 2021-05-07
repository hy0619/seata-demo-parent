package com.media.business.call;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import response.ObjectResponse;

/**
 * @Description http 远程调用
 * @Author hero1
 * @Date 2021/5/7
 * @Version 1.0.0
 */
@Service
public class RemoteCall {

    @Autowired
    RestTemplate restTemplate;

    public static final String STORAGE_SERVICE = "http://localhost:83/storage/";
    public static final String ORDER_SERVICE = "http://localhost:82/order/";

    final String commodityCode = "C201901140001";
    final Integer count = 1 ;
    final String userId = "1";
    final Double ammont = 1d;
    /**
     * @description: 扣库存
     * @return: response.ObjectResponse
     * @author: Hero
     * @date: 2021/5/7
     */
    public ObjectResponse decreaseStorage(){

        String url = STORAGE_SERVICE  + "/decrease" +
                "?commodityCode="+ commodityCode +"&count=" + count;
        return restTemplate.getForObject(url, ObjectResponse.class);
    }


    /**
     * @description: 创建订单
     * @return: response.ObjectResponse
     * @author: Hero
     * @date: 2021/5/7
     * /create")
     *     public ObjectResponse<Order> createOrder(String userId , double ammount
     */
    public ObjectResponse crateOrder(){
        String url = ORDER_SERVICE  + "/create" +
                "?userId="+ userId +"&ammount=" + ammont;
        return restTemplate.getForObject(url, ObjectResponse.class);
    }

}
