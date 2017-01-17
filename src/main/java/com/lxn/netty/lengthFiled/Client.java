package com.lxn.netty.lengthFiled;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

/**
 * Created by Lin Xiangnan on 2017/1/6.
 *
 *  4种方式分割消息
 *  （
 *  1、固定长度（占用资源浪费，不足需补）
 *  2、回车换行符——LineBasedFrameDecoder（HTTP采用此种）
 *  3、特定分割符（自定义，如($_)）
 *  4、协议头包含长度标识
 *  ）
 *  上述消息分割做的大部分功能是将分包整合为整包，从byte[]到byte[]，如果需要转为自定义pojo，应再嵌套一层byteToMessage
 *
 * @author Lin Xiangnan
 * @func    使用协议头长度标识确认消息分割
 **/
public class Client {

    public static void main(String[] args) throws InterruptedException {

        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try{

            ChannelInitializer channelInitializer = new ChannelInitializer<SocketChannel>(){
                @Override
                public void initChannel(SocketChannel sc){
                    // (根据协议头中设置的body长度，将body分包合并为整包)将接收的分包的ByteBuf合并为整包的ByteBuf
                    sc.pipeline().addLast(new LengthFieldBasedFrameDecoder(65536, 2, 4, 0, 0));

                    // 将整包的ByteBuf转为Message对象
                    sc.pipeline().addLast(new ByteBufToMessageDecoder());
                    // 将Message对象转为User对象
                    sc.pipeline().addLast(new MessageToUserDecoder());

                    // 将Message对象编码为字节流发送
                    sc.pipeline().addLast(new OwnMessageToByteEncoder());
                    // 将User对象转为Message对象
                    sc.pipeline().addLast(new UserToMessageEncoder());

                    // 处理解码后的User对象及建立通道发送User对象等
                    sc.pipeline().addLast(new LengthFiledClientHandler());
                }
            };

            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(workerGroup);
            bootstrap.channel(NioSocketChannel.class);
            bootstrap.option(ChannelOption.SO_KEEPALIVE, true);
            bootstrap.handler(channelInitializer);

            ChannelFuture channelFuture = bootstrap.connect("localhost", 8080).sync();
            channelFuture.channel().closeFuture().sync();
        }finally {
            workerGroup.shutdownGracefully();
        }

    }

}
