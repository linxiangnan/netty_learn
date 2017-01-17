package com.lxn.netty.codecTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lxn.netty.model.User;

import java.io.IOException;
import java.util.Date;

/**
 * Created by Lin Xiangnan on 2017/1/10.
 *
 * @author Lin Xiangnan
 * @func
 **/
public class TestJackson {

    private static ObjectMapper objectMapper = new ObjectMapper();

    static byte[] encode(Object obj) throws JsonProcessingException {

        return objectMapper.writeValueAsBytes(obj);

    }

    static User decode(byte[] bytes) throws IOException {

        return objectMapper.readValue(bytes, User.class);

    }

//    public static void main(String[] args) throws Exception {
//        User user = new User();
//        user.setUserId(111111111111111L);
//        user.setUsername("666000111");
//        user.setName("Mike");
//        user.setPassword("password");
//        user.setText("I'm Mike.");
//        System.out.println("before encode:" + user.toString());
//        System.out.println(new Date().getTime());
//        byte[] bytes = encode(user);
//        User reUser = decode(bytes);
//        System.out.println(new Date().getTime());
//        System.out.println(bytes.length);
//        System.out.println("after encode:" + reUser.toString());
//        System.out.println("Assert equal: " + reUser.equals(user));
//
//    }

}
