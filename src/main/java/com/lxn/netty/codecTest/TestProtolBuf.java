package com.lxn.netty.codecTest;

import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import com.lxn.netty.model.protoModel.UserProto;

import java.io.UnsupportedEncodingException;
import java.util.Date;

/**
 * Created by Lin Xiangnan on 2017/1/10.
 *
 * @author Lin Xiangnan
 * @func
 **/
public class TestProtolBuf {

    static byte [] encode(UserProto.User req){
        return req.toByteArray();
    }

    static UserProto.User decode(byte [] body)
            throws InvalidProtocolBufferException {
        return UserProto.User.parseFrom(body);
    }

    static UserProto.User createUser() throws UnsupportedEncodingException {
        UserProto.User.Builder builder = UserProto.User.newBuilder();
        builder.setUserId(111111111111111L);
        builder.setUsername("666000111");
        builder.setName("林向南");
        builder.setPassword("password");
        builder.setText("I'm 林向南.");

        return builder.build();
    }


    public static void main(String[] args)throws Exception {
        UserProto.User req = createUser();
        System.out.println("before encode:"+ req.toString());
        System.out.println(new Date().getTime());
        byte[] bytes = encode(req);
        UserProto.User req2 = decode(bytes);
        System.out.println(new Date().getTime());
        System.out.println(bytes.length);
        System.out.println("after encode:"+ req2.toString());
        System.out.println("Assert equal: " + req2.equals(req));

    }


}
