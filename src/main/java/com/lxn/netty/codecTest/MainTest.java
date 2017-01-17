package com.lxn.netty.codecTest;

import com.lxn.netty.model.User;
import com.lxn.netty.model.protoModel.UserProto;

import java.util.Date;

/**
 * Created by Lin Xiangnan on 2017/1/11.
 *
 * @author Lin Xiangnan
 * @func
 **/
public class MainTest {


    public static void main(String[] args)throws Exception {

        User user = new User();
        user.setUserId(111111111111111L);
        user.setUsername("666000111");
        user.setName("林向南");
        user.setPassword("password");
        user.setText("I'm 林向南111。");

        UserProto.User user2 = TestProtolBuf.createUser();

        // 测试protobuf(跨语言，编码数量极少，编解码速度极快，model复杂)
        System.out.println("--------------------------------protobuf---------------------------------");
        System.out.println("before encode:"+ user2.toString());
        Date startTime4 = new Date();
        System.out.println("startTime:"+startTime4.getTime());
        byte[] bytes4 = TestProtolBuf.encode(user2);
        UserProto.User reUser4 = TestProtolBuf.decode(bytes4);
        Date endTime4 = new Date();
        System.out.println("endTime:"+endTime4.getTime());
        System.out.println("after encode:"+ reUser4.toString());
        System.out.println("Assert equal: " + reUser4.equals(user2));
        System.out.println("byte数组长度："+bytes4.length+"。");
        System.out.println("编解码时间（毫秒数）："+(endTime4.getTime()-startTime4.getTime())+"。");
        System.out.println("-------------------------------------------------------------------------");

        // 测试java serializable(无法跨语言，编码数量过多，编解码速度快，model较简单)
        System.out.println("----------------------------java serializable-----------------------------");
        System.out.println("before encode:"+ user.toString());
        Date startTime5 = new Date();
        System.out.println("startTime:"+startTime5.getTime());
        byte[] bytes5 = TestJavaSerializable.encode(user);
        User reUser5 = TestJavaSerializable.decode(bytes5);
        Date endTime5 = new Date();
        System.out.println("endTime:"+endTime5.getTime());
        System.out.println("after encode:"+ reUser5.toString());
        System.out.println("Assert equal: " + reUser5.equals(user));
        System.out.println("byte数组长度："+bytes5.length+"。");
        System.out.println("编解码时间（毫秒数）："+(endTime5.getTime()-startTime5.getTime())+"。");
        System.out.println("-------------------------------------------------------------------------");

        // 测试fastJson(跨语言，编码数量较少，编解码速度较快，model简单)
        System.out.println("----------------------------------gson-----------------------------------");
        System.out.println("before encode:"+ user.toString());
        Date startTime3 = new Date();
        System.out.println("startTime:"+startTime3.getTime());
        byte[] bytes3 = TestGson.encode(user);
        User reUser3 = TestGson.decode(bytes3);
        Date endTime3 = new Date();
        System.out.println("endTime:"+endTime3.getTime());
        System.out.println("after encode:"+ reUser3.toString());
        System.out.println("Assert equal: " + reUser3.equals(user));
        System.out.println("byte数组长度："+bytes3.length+"。");
        System.out.println("编解码时间（毫秒数）："+(endTime3.getTime()-startTime3.getTime())+"。");
        System.out.println("-------------------------------------------------------------------------");

        // 测试fastJson(跨语言，编码数量较少，编解码速度较快，model简单)
        System.out.println("-------------------------------fastJson---------------------------------");
        System.out.println("before encode:"+ user.toString());
        Date startTime2 = new Date();
        System.out.println("startTime:"+startTime2.getTime());
        byte[] bytes2 = TestFastJson.encode(user);
        User reUser2 = TestFastJson.decode(bytes2);
        Date endTime2 = new Date();
        System.out.println("endTime:"+endTime2.getTime());
        System.out.println("after encode:"+ reUser2.toString());
        System.out.println("Assert equal: " + reUser2.equals(user));
        System.out.println("byte数组长度："+bytes2.length+"。");
        System.out.println("编解码时间（毫秒数）："+(endTime2.getTime()-startTime2.getTime())+"。");
        System.out.println("-------------------------------------------------------------------------");

        // 测试jackson(跨语言，编码数量较少，编解码速度较慢，model简单)
        System.out.println("-------------------------------jackson---------------------------------");
        System.out.println("before encode:"+ user.toString());
        Date startTime1 = new Date();
        System.out.println("startTime:"+startTime1.getTime());
        byte[] bytes1 = TestJackson.encode(user);
        User reUser1 = TestJackson.decode(bytes1);
        Date endTime1 = new Date();
        System.out.println("endTime:"+endTime1.getTime());
        System.out.println("after encode:"+ reUser1.toString());
        System.out.println("Assert equal: " + reUser1.equals(user));
        System.out.println("byte数组长度："+bytes1.length+"。");
        System.out.println("编解码时间（毫秒数）："+(endTime1.getTime()-startTime1.getTime())+"。");
        System.out.println("-------------------------------------------------------------------------");


    }

}
