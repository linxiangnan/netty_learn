package com.lxn.netty.discard;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

import java.io.UnsupportedEncodingException;

/**
 * Created by Lin Xiangnan on 2017/1/5.
 *
 * @author Lin Xiangnan
 * @func
 **/
public class DiscardServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws UnsupportedEncodingException { // (2)
        // Discard the received data silently.
        try {
            // Do something with msg
            ByteBuf buf = (ByteBuf)msg;
            byte[] req = new byte[buf.readableBytes()];
            buf.readBytes(req);
            String body = new String(req,"UTF-8");
            System.out.println("已接收到信息!");
            System.out.println(body);
        }
        finally {
            // ByteBuf 是一个引用计数对象，这个对象必须显示地调用 release() 方法来释放。
            ReferenceCountUtil.release(msg);
        }
//        System.out.println("已接收到信息!");
//        ctx.write(msg);
//        ctx.flush();
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) { // (4)
        // Close the connection when an exception is raised.
        cause.printStackTrace();
        ctx.close();
    }

}
