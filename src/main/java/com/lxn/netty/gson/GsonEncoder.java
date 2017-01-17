package com.lxn.netty.gson;

import com.google.gson.Gson;
import com.lxn.netty.model.User;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;

import java.util.List;

import static io.netty.buffer.Unpooled.wrappedBuffer;

/**
 * Created by Lin Xiangnan on 2017/1/13.
 *
 * @author Lin Xiangnan
 * @func
 **/
public class GsonEncoder extends MessageToMessageEncoder<String> {

    private Gson singletonGson = new Gson();

    @Override
    protected void encode(ChannelHandlerContext ctx, String msg, List<Object> out) throws Exception {

        out.add(wrappedBuffer(msg.getBytes("UTF-8")));
//        out.add(wrappedBuffer(singletonGson.toJson(msg).getBytes("UTF-8")));
    }
}
