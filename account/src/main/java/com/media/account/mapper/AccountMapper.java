package com.media.account.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.media.account.entity.Account;
import org.apache.ibatis.annotations.Param;

/**
 * @author Administrator
 */
public interface AccountMapper extends BaseMapper<Account> {
    /**
     * according userid to decrease account amount
     * @param userId
     * @param amount
     * @return
     */
    int decreaseAccount(@Param(value = "userId") String userId, @Param(value = "amount") double amount);
}
