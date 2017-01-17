package com.lxn.netty.time.client;

import com.lxn.netty.time.model.Time;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * Created by Lin Xiangnan on 2017/1/6.
 *
 * @author Lin Xiangnan
 * @func
 **/
public class TimeClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
//        ByteBuf m = (ByteBuf) msg; // (1)
//        try {
//            System.out.println("已接收到信息！");
//            System.out.println("--------------------------------------------------");
//            long currentTimeMillis = (m.readUnsignedInt() - 2208988800L) * 1000L;
//            System.out.println(new Date(currentTimeMillis));
//            System.out.println("--------------------------------------------------");
//            ctx.close();
//        } finally {
//            m.release();
//        }
        Time time = (Time) msg; // (1)
        System.out.println("已接收到信息！");
        System.out.println("--------------------------------------------------");
        System.out.println(time);
        System.out.println("--------------------------------------------------");
        ctx.close();
    }
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }

}
