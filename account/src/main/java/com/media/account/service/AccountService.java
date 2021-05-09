package com.media.account.service;

import com.media.account.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.media.ObjectResponse;

/**
 * @author Administrator
 */
@Service
public class AccountService {
    @Autowired
    AccountMapper accountMapper;


    public ObjectResponse decreaseAccount(String userId , double amount){
        int updNum = accountMapper.decreaseAccount(userId , amount);
        return updNum > 0 ? ObjectResponse.success() : ObjectResponse.fail();
    }

}
