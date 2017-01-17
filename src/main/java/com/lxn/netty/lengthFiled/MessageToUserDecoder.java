package com.lxn.netty.lengthFiled;

import com.google.gson.Gson;
import com.lxn.netty.model.User;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.MessageToMessageDecoder;

import java.nio.charset.Charset;
import java.util.List;

/**
 * Created by Lin Xiangnan on 2017/1/13.
 *
 * @author Lin Xiangnan
 * @func
 **/
public class MessageToUserDecoder extends MessageToMessageDecoder<Message> {

    private final static int HEADER_SIZE = 6;

    @Override
    protected void decode(ChannelHandlerContext ctx, Message msg, List<Object> out) throws Exception {
        out.add(msg.getObject());
    }

//    private final static int maxFrameLength = 199999999;
//    private final static int lengthFieldOffset = 2;
//    private final static int lengthFieldLength = 4;
//    private final static int lengthAdjustment = 0;
//    private final static int initialBytesToStrip = 0;
//    private final static boolean failFast = false;
//
//    private final static int HEADER_SIZE = 6;
//
//
//
//    /**
//     *
//     * @param maxFrameLength 解码时，处理每个帧数据的最大长度
//     * @param lengthFieldOffset 该帧数据中，存放该帧数据的长度的数据的起始位置
//     * @param lengthFieldLength 记录该帧数据长度的字段本身的长度
//     * @param lengthAdjustment 修改帧数据长度字段中定义的值，可以为负数
//     * @param initialBytesToStrip 解析的时候需要跳过的字节数
//     * @param failFast 为true，当frame长度超过maxFrameLength时立即报TooLongFrameException异常，为false，读取完整个帧再报异常
//     */
//    public LengthFiledDecoder(int maxFrameLength, int lengthFieldOffset, int lengthFieldLength, int lengthAdjustment, int initialBytesToStrip, boolean failFast) {
//        super(maxFrameLength, lengthFieldOffset, lengthFieldLength, lengthAdjustment, initialBytesToStrip, failFast);
//    }
//
//    public LengthFiledDecoder() {
//        super(maxFrameLength, lengthFieldOffset, lengthFieldLength, lengthAdjustment, initialBytesToStrip, failFast);
//    }
//
//    @Override
//    protected Object decode(ChannelHandlerContext ctx, ByteBuf in) throws Exception {
//        if (in.readableBytes() < HEADER_SIZE) {
//            throw new Exception("可读信息段小于头部信息，无法读取");
//        }
//
//        //注意在读的过程中，readIndex的指针也在移动
//        byte type = in.readByte();
//
//        byte flag = in.readByte();
//
//        int setLength = in.readInt();
//
//        int actualLength = in.readableBytes();
//
//        if (actualLength != setLength) {
//            throw new Exception("消息body长度显示为："+setLength+",但实际消息body长度为："+actualLength+"。");
//        }
//        ByteBuf buf = in.readBytes(actualLength);
//        byte[] bytes = new byte[buf.readableBytes()];
//        buf.readBytes(bytes);
//
//        return new Gson().fromJson(new String(bytes, Charset.forName("UTF-8")), User.class);
//    }


}
