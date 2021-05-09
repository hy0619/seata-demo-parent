package com.media.storage.controller;

import com.media.ObjectResponse;
import com.media.storage.service.StorageService;
import io.seata.core.context.RootContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description 商品库存service
 * @Author hero
 * @Date 2021/5/7
 * @Version 1.0.0
 */
@RestController
@RequestMapping("/storage")
public class StorageController {
    @Autowired
    StorageService storageService;

    /**
     * @param: commodityCode
     * @param: count
     * @description: 减库存api
     * @return: response.ObjectResponse
     * @author: niaonao
     * @date: 2021/5/7
     */
    @GetMapping("/decrease")
    public ObjectResponse decrease(String commodityCode , Integer count , HttpServletRequest request){
        System.out.println(request.getHeader(RootContext.KEY_XID.toLowerCase()));
        return storageService.decreaseStorage(commodityCode , count);
    }
}
