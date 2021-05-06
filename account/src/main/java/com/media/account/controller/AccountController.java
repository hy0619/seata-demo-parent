package com.media.account.controller;

import com.media.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import response.ObjectResponse;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService accountService;
    @GetMapping("/decrease/{userId}/{ammount}")
    public ObjectResponse decreaseAccount(@PathVariable  String userId , @PathVariable double ammount){
       return accountService.decreaseAccount(userId , ammount);
    }
}
