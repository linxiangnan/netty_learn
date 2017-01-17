package com.lxn.netty.protobuf.server;

import com.google.protobuf.ByteString;
import com.lxn.netty.model.protoModel.ResponseUserProto;
import com.lxn.netty.model.protoModel.UserProto;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.springframework.util.StringUtils;

import java.io.UnsupportedEncodingException;
import java.util.Date;

/**
 * Created by Lin Xiangnan on 2017/1/11.
 *
 * @author Lin Xiangnan
 * @func
 **/
public class ServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        // 收到消息
        System.out.println("-----------------server接收到消息！-----------"+new Date().getTime()+"-------------");
        // 已经过protobuf转码
        UserProto.User user = (UserProto.User) msg;
        // 打印接收到的消息
        System.out.println(user.toString());
//        System.out.println(user.toByteString().toStringUtf8());
        // 获取消息字段
        long userId = user.getUserId();
        String name = user.getName();
        String text = user.getText();
        // 构建protobuf返回消息
        ResponseUserProto.ResponseUser responseUser = response(userId, name, text);
        // 返回消息
        ctx.writeAndFlush(responseUser);
        System.out.println("-----------------server接收并已返回消息！-------------------------------------------");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("远程连接已关闭！");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) { // (4)
        // Close the connection when an exception is raised.
        cause.printStackTrace();
        ctx.close();
    }

    private ResponseUserProto.ResponseUser response(long userId, String name, String text) throws UnsupportedEncodingException {
        ResponseUserProto.ResponseUser.Builder builder = ResponseUserProto.ResponseUser.newBuilder();
        builder.setUserId(userId);
        String helloText;
        if (StringUtils.isEmpty(text)){
            helloText = "hello " + name + ",you didn't say any text。";
        }
        else {
            helloText = "hello " + name + ",your text is :" + text + "。";
        }
        builder.setHelloText(helloText);
        return builder.build();
    }

}
