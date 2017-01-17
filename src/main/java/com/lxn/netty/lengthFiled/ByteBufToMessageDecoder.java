package com.lxn.netty.lengthFiled;

import com.google.gson.Gson;
import com.lxn.netty.model.User;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.nio.charset.Charset;
import java.util.List;

/**
 * Created by Lin Xiangnan on 2017/1/17.
 *
 * @author Lin Xiangnan
 * @func
 **/
public class ByteBufToMessageDecoder extends ByteToMessageDecoder {

    private final static int HEADER_SIZE = 6;

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {

        if (in.readableBytes() < HEADER_SIZE) {
            throw new Exception("可读信息段小于头部信息，无法读取");
        }

        //注意在读的过程中，readIndex的指针也在移动
        byte type = in.readByte();

        byte flag = in.readByte();

        int setLength = in.readInt();

        int actualLength = in.readableBytes();

        if (actualLength != setLength) {
            throw new Exception("消息body长度显示为："+setLength+",但实际消息body长度为："+actualLength+"。");
        }
        ByteBuf buf = in.readBytes(actualLength);
        byte[] bytes = new byte[buf.readableBytes()];
        buf.readBytes(bytes);

        User user = new Gson().fromJson(new String(bytes, Charset.forName("UTF-8")), User.class);
        Message message = new Message();
        message.setType(type);
        message.setFlag(flag);
        message.setObject(user);

        out.add(message);

    }
}
