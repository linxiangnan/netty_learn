package com.lxn.netty.codecTest;

import com.lxn.netty.model.User;

import java.io.*;
import java.util.Date;

/**
 * Created by Lin Xiangnan on 2017/1/16.
 *
 * @author Lin Xiangnan
 * @func
 **/
public class TestJavaSerializable  {

    static byte[] encode(User user) throws IOException {
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(byteOut);
        try {
            oos.writeObject(user);
            return byteOut.toByteArray();
        }finally {
            byteOut.close();
            oos.close();
        }
    }

    static User decode(byte[] bytes) throws IOException, ClassNotFoundException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        ObjectInputStream ois = new ObjectInputStream(byteArrayInputStream);
        try {
            return (User) ois.readObject();
        }
        finally {
            byteArrayInputStream.close();
            ois.close();
        }
    }

    public static void main(String[] args) throws Exception {
        User user = new User();
        user.setUserId(111111111111111L);
        user.setUsername("666000111");
        user.setName("Mike");
        user.setPassword("password");
        user.setText("I'm Mike.");
        System.out.println("before encode:" + user.toString());
        System.out.println(new Date().getTime());
        byte[] bytes = encode(user);
        User reUser = decode(bytes);
        System.out.println(new Date().getTime());
        System.out.println(bytes.length);
        System.out.println("after encode:" + reUser.toString());
        System.out.println("Assert equal: " + reUser.equals(user));

    }

}
