package com.media.account;

import com.media.account.service.AccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import response.ObjectResponse;

@SpringBootTest
class AccountApplicationTests {
    @Autowired
    AccountService accountService;


    @Test
    public void testInsertAccount(){
        ObjectResponse objectResponse = accountService.decreaseAccount("heyi-01", 10d);

        System.out.println(objectResponse.toString());
    }

}
