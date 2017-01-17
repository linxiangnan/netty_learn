package com.lxn.netty.protobuf.client;

import com.lxn.netty.model.protoModel.ResponseUserProto;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;

/**
 * Created by Lin Xiangnan on 2017/1/11.
 *
 * @author Lin Xiangnan
 * @func
 **/
public class ProtoClient {

    private void run() throws InterruptedException {

        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ChannelInitializer channelInitializer = new ChannelInitializer<SocketChannel>() {
                @Override
                public void initChannel(SocketChannel sc) {
                    ChannelPipeline cp = sc.pipeline();
                    // 添加protobuf编、解码处理器
                    // protobuf解码器
                    cp.addLast(new ProtobufVarint32FrameDecoder());
                    // 解码类型
                    cp.addLast(new ProtobufDecoder(ResponseUserProto.ResponseUser.getDefaultInstance()));
                    // protobuf编码器
                    cp.addLast(new ProtobufVarint32LengthFieldPrepender());
                    // 编码器
                    cp.addLast(new ProtobufEncoder());
                    // 业务处理器
                    cp.addLast(new ClientHandler());
                }
            };

            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(workerGroup);
            bootstrap.channel(NioSocketChannel.class);
            bootstrap.handler(channelInitializer);
            bootstrap.option(ChannelOption.TCP_NODELAY, true);

            ChannelFuture channelFuture = bootstrap.connect("localhost", 8080).sync();

            channelFuture.channel().closeFuture().sync();
        }
        finally {
            workerGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ProtoClient protoClient = new ProtoClient();
        protoClient.run();

    }

}
