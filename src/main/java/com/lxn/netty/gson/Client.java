package com.lxn.netty.gson;

import com.lxn.netty.model.User;
import com.lxn.netty.time.client.TimeClientHandler;
import com.lxn.netty.time.client.TimeDecoder;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;

/**
 * Created by Lin Xiangnan on 2017/1/6.
 *
 * @author Lin Xiangnan
 * @func    使用分隔符分割消息并读取string（$_）
 **/
public class Client {

    public static void main(String[] args) throws InterruptedException {

        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try{

            ChannelInitializer channelInitializer = new ChannelInitializer<SocketChannel>(){
                @Override
                public void initChannel(SocketChannel sc){
                    ByteBuf delimiter = Unpooled.copiedBuffer("$_".getBytes());
                    sc.pipeline().addLast(new DelimiterBasedFrameDecoder(1024, delimiter));
                    sc.pipeline().addLast(new GsonDecoder());
                    sc.pipeline().addLast(new GsonEncoder());
                    sc.pipeline().addLast(new GsonClientHandler());
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
