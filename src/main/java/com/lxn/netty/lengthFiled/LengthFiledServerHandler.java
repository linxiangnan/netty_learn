package com.lxn.netty.lengthFiled;

import com.lxn.netty.model.User;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

/**
 * Created by Lin Xiangnan on 2017/1/13.
 *
 * @author Lin Xiangnan
 * @func
 **/
public class LengthFiledServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        User user = (User) msg;
        System.out.println("接收到数据。--------------------------");
        System.out.println(user.toString());
        System.out.println("-------------------------------------");

        ctx.writeAndFlush(user);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
            throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

}
