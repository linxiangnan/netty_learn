package com.lxn.netty.lengthFiled;

import com.lxn.netty.model.User;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;

import java.util.List;

/**
 * Created by Lin Xiangnan on 2017/1/16.
 *
 * @author Lin Xiangnan
 * @func
 **/
public class UserToMessageEncoder extends MessageToMessageEncoder<User> {

    @Override
    protected void encode(ChannelHandlerContext ctx, User msg, List<Object> out) throws Exception {

        Message message = new Message();
        message.setType((byte)0xAB);
        message.setFlag((byte)0xCD);
        message.setObject(msg);

        out.add(message);

    }
}
