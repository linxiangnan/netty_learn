package com.lxn.netty.model;

import java.io.Serializable;

/**
 * Created by Lin Xiangnan on 2017/1/10.
 *
 * @author Lin Xiangnan
 * @func
 **/
public class ResponseUser implements Serializable {

    private static final long serialVersionUID = -1186632656409738773L;

    private long userId;
    private String helloText;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getHelloText() {
        return helloText;
    }

    public void setHelloText(String helloText) {
        this.helloText = helloText;
    }

    @Override
    public String toString() {
        return "ResponseUser{" +
                "userId=" + userId +
                ", helloText='" + helloText + '\'' +
                '}';
    }
}
