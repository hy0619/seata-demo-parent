package com.media.business.service;

import com.media.business.call.RemoteCall;
import enums.RspStatusEnum;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import response.ObjectResponse;

/**
 * @Description 业务service
 * @Author Hero
 * @Date 2021/5/7
 * @Version 1.0.0
 */
@Service
public class BusinessService {
    @Autowired
    RemoteCall remoteCall ;

    private volatile boolean exceptionFlag = true;

    /**
     * @description: 正常购买逻辑
     * @return: response.ObjectResponse
     * @author: Hero
     * @date: 2021/5/7
     */
    @GlobalTransactional
    public ObjectResponse buy(){
        ObjectResponse decStorageRes = remoteCall.decreaseStorage();
        ObjectResponse createOrderRes = remoteCall.crateOrder();

        return decStorageRes.getStatus() == RspStatusEnum.FAIL.getCode()
                || createOrderRes.getStatus() == RspStatusEnum.FAIL.getCode() ?

                ObjectResponse.fail() : ObjectResponse.success();

    }

    /**
     * @description: 模拟异常情况 测试回滚
     * @return: response.ObjectResponse
     * @author: Hero
     * @date: 2021/5/7
     */
    @GlobalTransactional
    public ObjectResponse buyForRollback(){
        System.out.println(RootContext.getXID());
        ObjectResponse decStorageRes = remoteCall.decreaseStorage();
        if(exceptionFlag){
            throw new RuntimeException(RspStatusEnum.FAIL.getMessage());
        }
        ObjectResponse createOrderRes = remoteCall.crateOrder();


        return decStorageRes.getStatus() == RspStatusEnum.FAIL.getCode()
                || createOrderRes.getStatus() == RspStatusEnum.FAIL.getCode() ?

                ObjectResponse.fail() : ObjectResponse.success();



    }


}
