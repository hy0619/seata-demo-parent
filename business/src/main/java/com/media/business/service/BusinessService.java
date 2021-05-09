package com.media.business.service;

import com.media.business.call.RemoteCall;
import com.media.common.RspStatusEnum;
import io.seata.core.context.RootContext;
import io.seata.core.exception.TransactionException;
import io.seata.rm.RMClient;
import io.seata.spring.annotation.GlobalTransactional;
import io.seata.tm.TMClient;
import io.seata.tm.api.GlobalTransaction;
import io.seata.tm.api.GlobalTransactionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.media.ObjectResponse;

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


    public ObjectResponse buy2RollBackOps() throws TransactionException {
        //init seata; only once
        String applicationId = "seata-biz";
        String txServiceGroup = "my_test_tx_group";
        TMClient.init(applicationId, txServiceGroup);
        RMClient.init(applicationId, txServiceGroup);
        GlobalTransaction tx = GlobalTransactionContext.getCurrentOrCreate();
        System.out.println("begin trx, xid is " + tx.getXid());
        ObjectResponse createOrderRes =null , decStorageRes = null;
        try{
            tx.begin(60000, "testBiz");
            decStorageRes = remoteCall.decreaseStorage();
            if(exceptionFlag){
                throw new RuntimeException(RspStatusEnum.FAIL.getMessage());
            }
            createOrderRes = remoteCall.crateOrder();
            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {

        }

        return decStorageRes.getStatus() == RspStatusEnum.FAIL.getCode()
                 ?

                ObjectResponse.fail() : ObjectResponse.success();


    }
}
