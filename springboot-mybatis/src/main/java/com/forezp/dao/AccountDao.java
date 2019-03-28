package com.forezp.dao;

import com.forezp.entity.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AccountDao {

    List<Account> findAccountList();

    Account findById(@Param("id") int id);
}