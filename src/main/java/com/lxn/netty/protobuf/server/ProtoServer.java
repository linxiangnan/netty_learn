package com.lxn.netty.protobuf.server;

import com.lxn.netty.model.protoModel.UserProto;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;

/**
 * Created by Lin Xiangnan on 2017/1/9.
 *
 * @author Lin Xiangnan
 * @func    接收传入数据，并以protobuf编解码
 **/
public class ProtoServer {

    private int port;

    public ProtoServer(){
        // 默认端口绑定设置8080
        this.port=8080;
    }

    public ProtoServer(int port){
        this.port=port;
    }

    private void run() throws InterruptedException {

        // 创建两个事件循环组（boss用于监听接收连接，worker用于处理接收到的连接）
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try{

            // 添加频道初始化及相关参数
            ChannelInitializer channelInitializer = new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    ChannelPipeline cp = ch.pipeline();
                    // 添加protoBuf相关编、解码处理流程
                    // protobuf解码器
                    cp.addLast(new ProtobufVarint32FrameDecoder());
                    // protobuf解码类型
                    cp.addLast(new ProtobufDecoder(UserProto.User.getDefaultInstance()));
                    // protobuf编码器
                    cp.addLast(new ProtobufVarint32LengthFieldPrepender());
                    // protobuf编码类型
                    cp.addLast(new ProtobufEncoder());
                    // 业务逻辑处理
                    cp.addLast(new ServerHandler());
                }
            };

            // 添加server启动
            ServerBootstrap sb = new ServerBootstrap();
            sb.group(bossGroup, workerGroup);
            sb.channel(NioServerSocketChannel.class);
            sb.childHandler(channelInitializer);
            // 当服务器请求处理线程全满时，用于临时存放已完成三次握手的请求的队列的最大长度。
            sb.option(ChannelOption.SO_BACKLOG, 128);
            // 心跳保活机制
            sb.childOption(ChannelOption.SO_KEEPALIVE, true);

            // 绑定端口
            ChannelFuture channelFuture = sb.bind(port).sync();

            // 断开连接
            channelFuture.channel().closeFuture().sync();


        }finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }


    }

    public static void main(String[] args) throws InterruptedException {
        ProtoServer protoServer = new ProtoServer();
        protoServer.run();
    }

}
