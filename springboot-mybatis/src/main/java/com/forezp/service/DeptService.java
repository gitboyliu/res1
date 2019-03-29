package com.forezp.service;

import com.forezp.dao.DeptDao;
import com.forezp.entity.dept;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * copyright(c) 2019
 * FileName:DeptService
 * Author:  ynFrineds
 * Description:Oracle service
 * create :2019/3/29
 */
@Service
public class DeptService {

    @Resource
    private DeptDao deptDao;

    @Resource
    private RedisUtil redisUtil;

    public List<dept> getPtList(){

        List<dept> list=(List<dept>)redisUtil.getValue("oraclList");
        if (list==null){
            list=deptDao.getPtList();
            redisUtil.setValue("oraclList",list,100, TimeUnit.SECONDS);
        }
        return list;
    }
}
