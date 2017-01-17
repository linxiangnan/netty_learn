package com.lxn.netty.gson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lxn.netty.model.User;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;

import java.util.List;

/**
 * Created by Lin Xiangnan on 2017/1/13.
 *
 * @author Lin Xiangnan
 * @func
 **/
public class GsonDecoder extends MessageToMessageDecoder<ByteBuf> {

    private Gson singletonGson = new Gson();

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) throws Exception {

        byte[] bytes = new byte[msg.readableBytes()];
        msg.readBytes(bytes);
//        User object = singletonGson.fromJson(new String(bytes), User.class);
        out.add(new String(bytes));
    }
}
