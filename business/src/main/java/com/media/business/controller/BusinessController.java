package com.media.business.controller;

import com.media.business.service.BusinessService;
import io.seata.core.exception.TransactionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.media.ObjectResponse;

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

    @GetMapping("/rollback/buy2RollBackOps")
    public ObjectResponse buy2RollBackOps() throws TransactionException {
        return businessService.buy2RollBackOps();
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
