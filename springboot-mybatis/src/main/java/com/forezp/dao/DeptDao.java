package com.forezp.dao;

import com.forezp.entity.dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * copyright(c) 2019
 * FileName:DeptDao
 * Author:  ynFrineds
 * Description:Oracle Interface
 * create :2019/3/29
 */
@Mapper
public interface DeptDao {

    List<dept> getPtList();

}
