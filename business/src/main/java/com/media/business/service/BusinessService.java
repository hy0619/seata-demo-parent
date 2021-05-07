package com.media.business.service;

import com.media.business.call.RemoteCall;
import enums.RspStatusEnum;
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
    public ObjectResponse buyForRollback(){
        ObjectResponse decStorageRes = remoteCall.decreaseStorage();
        ObjectResponse createOrderRes = remoteCall.crateOrder();

        if(exceptionFlag){
            throw new RuntimeException(RspStatusEnum.FAIL.getMessage());
        }
        return decStorageRes.getStatus() == RspStatusEnum.FAIL.getCode()
                || createOrderRes.getStatus() == RspStatusEnum.FAIL.getCode() ?

                ObjectResponse.fail() : ObjectResponse.success();



    }


}
