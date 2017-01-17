package com.lxn.netty.codecTest;

import com.alibaba.fastjson.JSON;
import com.lxn.netty.model.User;

import java.util.Date;

/**
 * Created by Lin Xiangnan on 2017/1/10.
 *
 * @author Lin Xiangnan
 * @func
 **/
public class TestFastJson {

    static byte[] encode(Object obj){

        String objectStr = JSON.toJSONString(obj);
        return objectStr.getBytes();
    }

    static User decode(byte[] bytes){

        return JSON.parseObject(new String(bytes), User.class);

    }

//    public static void main(String[] args)throws Exception {
//        User user = new User();
//        user.setUserId(111111111111111L);
//        user.setUsername("666000111");
//        user.setName("Mike");
//        user.setPassword("password");
//        user.setText("I'm Mike.");
//        System.out.println("before encode:"+ user.toString());
//        System.out.println(new Date().getTime());
//        byte[] bytes = encode(user);
//        User reUser = decode(bytes);
//        System.out.println(new Date().getTime());
//        System.out.println(bytes.length);
//        System.out.println("after encode:"+ reUser.toString());
//        System.out.println("Assert equal: " + reUser.equals(user));
//
//    }
}
