package com.forezp.web;

import com.forezp.service.AccountService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by fangzhipeng on 2017/4/20.
 */
@RestController
public class AccountController2 {
    @Autowired
    AccountService2 accountService;

    @RequestMapping(value = "transfer", method = RequestMethod.GET)
    public void transfer(){
        accountService.transfer();
    }
}
