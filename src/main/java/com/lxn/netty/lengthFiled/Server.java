package com.lxn.netty.lengthFiled;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

/**
 * Created by Lin Xiangnan on 2017/1/5.
 *
 * @author Lin Xiangnan
 * @func    使用协议头长度标识确认消息分割
 **/
public class Server {

    // 定义一个端口
    private int port;

    public Server(int port){
        this.port=port;
    }

    public void run() throws InterruptedException {

        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try{
            ChannelInitializer channelInitializer = new ChannelInitializer<SocketChannel>(){
                @Override
                public void initChannel(SocketChannel sc) throws Exception {
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

                    // 处理解码后的User对象及返回User对象等
                    sc.pipeline().addLast(new LengthFiledServerHandler());
                }
            };

            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(channelInitializer)
                    .option(ChannelOption.SO_BACKLOG, 128)
                    .childOption(ChannelOption.SO_KEEPALIVE, true);

            // 绑定端口，开始接收进来的数据
            ChannelFuture cf = bootstrap.bind(port).sync();

            // 等待服务器 socket关闭
            cf.channel().closeFuture().sync();

        }
        finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        new Server(8080).run();
    }

}
