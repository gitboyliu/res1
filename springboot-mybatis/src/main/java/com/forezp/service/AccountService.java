package com.forezp.service;

import com.forezp.dao.AccountDao;
import com.forezp.entity.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by fangzhipeng on 2017/4/20.
 */
@Service
public class AccountService {

    private  static final Logger LOGGER= LoggerFactory.getLogger(AccountService.class);

    @Resource
    private  RedisUtil redisUtil;

    @Resource
    private AccountDao accountMapper;

    public List<Account> findAccountList() {
        List<Account> list = (List<Account>) redisUtil.getValue("listKey");
        if(list==null){
            list = accountMapper.findAccountList();
            redisUtil.setValue("listKey",list,180, TimeUnit.SECONDS);
        }
        return list;
    }

    public Account findById(int id){
        return accountMapper.findById(id);
   }
}