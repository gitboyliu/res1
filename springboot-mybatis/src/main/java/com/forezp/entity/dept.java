package com.forezp.entity;

import java.io.Serializable;

/**
 * copyright(c) 2019
 * FileName:dept
 * Author:  ynFrineds
 * Description:Oracle测试连接
 * create :2019/3/29
 */
public class dept implements Serializable {


    private static final long serialVersionUID = 1L;

    private int deptno;
    private String dname;
    private  String loc;

    public int getDeptno() {
        return deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }
}
