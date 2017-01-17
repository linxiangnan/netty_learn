package com.lxn.netty.protobuf.client;

import com.google.protobuf.ByteString;
import com.lxn.netty.model.protoModel.ResponseUserProto;
import com.lxn.netty.model.protoModel.UserProto;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.io.UnsupportedEncodingException;
import java.util.Date;

/**
 * Created by Lin Xiangnan on 2017/1/11.
 *
 * @author Lin Xiangnan
 * @func
 **/
public class ClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        // 第一次连接，发送请求
        System.out.println("-----------------client首次连接发送消息！------------------------");
        // 五条消息创建
        for (int i = 0; i < 10; i++) {
            UserProto.User user = request(i, "666000111", "林向南", "111111", "hello！！！");
            // 打印发送消息
            System.out.println(user.toString());
//            System.out.println(user.toByteString().toString("UTF-8"));
            // 发送
            ctx.write(user);
        }
        ctx.flush();
        System.out.println("-----------------client首次发送消息完成！------------------------");

    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        // 收到消息
        System.out.println("-----------------client接收到消息！----------"+new Date().getTime()+"--------------");
        // 已经过protobuf转码
        ResponseUserProto.ResponseUser responseUser = (ResponseUserProto.ResponseUser) msg;
        // 打印接收的消息
        System.out.println(responseUser.toString());
//        System.out.println(responseUser.toByteString().toString("UTF-8"));
        System.out.println("-----------------client接收消息完成！----------------------------------------------");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) { // (4)
        // Close the connection when an exception is raised.
        cause.printStackTrace();
        ctx.close();
    }

    private UserProto.User request(long userId, String username, String name, String password, String text) throws UnsupportedEncodingException {
        UserProto.User.Builder builder = UserProto.User.newBuilder();
        builder.setUserId(userId);
        builder.setUsername(username);
        builder.setName(name);
        builder.setPassword(password);
        if(userId%2 == 0) {
            builder.setText(text);
        }
        return builder.build();
    }

}
