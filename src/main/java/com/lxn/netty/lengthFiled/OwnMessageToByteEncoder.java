package com.lxn.netty.lengthFiled;

import com.google.gson.Gson;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.handler.codec.MessageToMessageEncoder;

import java.nio.charset.Charset;
import java.util.List;

import static io.netty.buffer.Unpooled.wrappedBuffer;

/**
 * Created by Lin Xiangnan on 2017/1/13.
 *
 * @author Lin Xiangnan
 * @func
 **/
public class OwnMessageToByteEncoder extends io.netty.handler.codec.MessageToByteEncoder<Message> {


    @Override
    protected void encode(ChannelHandlerContext ctx, Message msg, ByteBuf out) throws Exception {
        if(null == msg){
            throw new Exception("Message不能为空。");
        }

        Object object = msg.getObject();
        byte[] objBytes = new Gson().toJson(object).getBytes(Charset.forName("UTF-8"));
        out.writeByte(msg.getType());
        out.writeByte(msg.getFlag());
        out.writeInt(objBytes.length);
        out.writeBytes(objBytes);

    }
}
