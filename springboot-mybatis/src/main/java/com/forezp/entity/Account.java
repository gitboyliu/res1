package com.forezp.entity;

import java.io.Serializable;

/**
 * Created by fangzhipeng on 2017/4/20.
 */
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id ;//Serializable
    private String name ;
    private double money;


    private bm b;

    public bm getB() {
        return b;
    }


    public void setB(bm b) {
        this.b = b;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money=" + money +
                '}';
    }
}
