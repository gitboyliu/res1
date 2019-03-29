package com.forezp.web;

import com.forezp.entity.dept;
import com.forezp.service.DeptService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * copyright(c) 2019
 * FileName:DeptController
 * Author:  ynFrineds
 * Description:Oracle Controller
 * create :2019/3/29
 */
@RestController
public class DeptController {

    @Resource
    private DeptService deptService;

    @RequestMapping(value = "/opracle",method = RequestMethod.GET)
    public List<dept> getPtList(){
        return deptService.getPtList();
    }
}
