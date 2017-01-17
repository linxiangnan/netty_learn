package com.lxn.netty.time.client;

import com.lxn.netty.time.model.Time;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * Created by Lin Xiangnan on 2017/1/6.
 *
 * @author Lin Xiangnan
 * @func
 **/
public class TimeDecoder extends ByteToMessageDecoder {

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        if (in.readableBytes()<4){
            return;
        }
        Time time = new Time(in.readUnsignedInt());
        out.add(time);
    }
}
