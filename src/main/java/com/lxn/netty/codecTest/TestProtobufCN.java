package com.lxn.netty.codecTest;

import com.google.gson.Gson;
import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import com.lxn.netty.model.protoModel.SimpleCNMessageProto;

import java.io.UnsupportedEncodingException;
import java.util.Date;

/**
 * Created by Lin Xiangnan on 2017/1/12.
 *
 * @author Lin Xiangnan
 * @func
 **/
public class TestProtobufCN {

    static byte [] encode(SimpleCNMessageProto.SimpleCNMessage simpleCNMessage){

        return simpleCNMessage.toByteArray();
    }

    static SimpleCNMessageProto.SimpleCNMessage decode(byte [] body)
            throws InvalidProtocolBufferException {
        return SimpleCNMessageProto.SimpleCNMessage.parseFrom(body);
    }

    static SimpleCNMessageProto.SimpleCNMessage createSimpleCNMessage() throws UnsupportedEncodingException {
        SimpleCNMessageProto.SimpleCNMessage.Builder builder = SimpleCNMessageProto.SimpleCNMessage.newBuilder();
        builder.setId(1454574);
        builder.setStringText("林向南.....");
        builder.setBytesText(ByteString.copyFromUtf8("林向南....."));

        return builder.build();
    }

    public static void main(String[] args)throws Exception {
        SimpleCNMessageProto.SimpleCNMessage req = createSimpleCNMessage();
        System.out.println("before encode:");
        System.out.println(req.toString());
        byte[] bytes = encode(req);
        SimpleCNMessageProto.SimpleCNMessage req2 = decode(bytes);
        System.out.println("after encode:");
        System.out.println(req2.toString());

    }

}
