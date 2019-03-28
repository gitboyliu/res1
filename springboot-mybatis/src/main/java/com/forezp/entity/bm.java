package com.forezp.entity;

import java.io.Serializable;

/**
 * copyright(c) 2019
 * FileName:bm
 * Author:  ynFrineds
 * Description:bm
 * create :2019/3/26
 */
public class bm implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private int acid;
    private String txt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAcid() {
        return acid;
    }

    public void setAcid(int acid) {
        this.acid = acid;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    @Override
    public String toString() {

        return "{id:"+id+"acid:"+acid+"txt:"+txt+"}";
    }
}
