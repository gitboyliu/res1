package com.forezp.web;

import com.forezp.entity.Account;
import com.forezp.service.AccountService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


@RestController
public class AccountController {

    @Resource
    AccountService accountService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Account> getAccounts() {
        return accountService.findAccountList();
    }

    @RequestMapping(value = "/find.php",method = RequestMethod.GET)
    public Account findById(@RequestParam(value = "id") String id){
        Account account=accountService.findById(Integer.parseInt(id));
        return account;
    }

}