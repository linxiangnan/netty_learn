package com.lxn.netty.time.server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.io.UnsupportedEncodingException;

/**
 * Created by Lin Xiangnan on 2017/1/5.
 *
 * @author Lin Xiangnan
 * @func
 **/
public class TimeServerHandler extends ChannelInboundHandlerAdapter {


    @Override
    public void channelActive(final ChannelHandlerContext ctx) { // (1)
        System.out.println("创建新连接成功！");
        final ByteBuf time = ctx.alloc().buffer(4); // (2)
        time.writeInt((int) (System.currentTimeMillis() / 1000L + 2208988800L));
        final ChannelFuture f = ctx.writeAndFlush(time); // (3)
//        f.addListener((ChannelFutureListener) future -> {
//            assert f == future;
//            ctx.close();
//        }); // (4)
        f.addListener(ChannelFutureListener.CLOSE);
    }

    @Override
    public void channelInactive(final ChannelHandlerContext ctx) { // (1)
        ctx.fireChannelInactive();
        System.out.println("断开连接成功！");
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws UnsupportedEncodingException {
        System.out.println("接收到数据信息！");
        System.out.println("-----------------------------------------");
        ByteBuf buf = (ByteBuf)msg;
        byte[] req = new byte[buf.readableBytes()];
        buf.readBytes(req);
        String body = new String(req,"UTF-8");
        System.out.println(body);
        System.out.println("-----------------------------------------");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) { // (4)
        // Close the connection when an exception is raised.
        cause.printStackTrace();
        ctx.close();
    }

}
