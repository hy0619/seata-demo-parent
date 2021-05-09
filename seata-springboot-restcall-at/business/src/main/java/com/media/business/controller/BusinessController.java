package com.media.business.controller;

import com.media.ObjectResponse;
import com.media.business.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CountDownLatch;

/**
 * @Description 业务Controller
 * @Author Hero
 * @Date 2021/5/7
 * @Version 1.0.0
 */
@RestController
@RequestMapping("/business")
public class BusinessController {
    @Autowired
    BusinessService businessService;


    /**
     * @description 多线程测试分布式事务
     * @author Hero
     * @param:
     * @return com.media.ObjectResponse
     * @date 2021-5-9 17:15
     */
    @GetMapping("/buy4MultiThread")
    public ObjectResponse buy4MultiThread() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(50);
        for(int i = 0 ; i < 50 ; i++){
            int finalI = i;
            new Thread(()->{
                businessService.buy();
                /*if(finalI % 2 ==0){
                    try {
                        businessService.buyForRollback();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }else{
                    businessService.buy();
                }*/
                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();

        System.err.println("down!!!!!!!!!!================================");
        return  ObjectResponse.success("success!!!");
    }


    /**
     * @description: 分布式事务正常提交
     * @return: response.ObjectResponse
     * @author: Hero
     * @date: 2021/5/7
     */
    @GetMapping("/nomal/commit")
    public ObjectResponse buy4NomallyNoException(){
        return businessService.buy();
    }

    /**
     * @description: 分布式事务异常回滚
     * @return: response.ObjectResponse
     * @author: Hero
     * @date: 2021/5/7
     */
    @GetMapping("/rollback/exception")
    public ObjectResponse buy4RollbackDistributeTransaction(){
        return businessService.buyForRollback();
    }
}
