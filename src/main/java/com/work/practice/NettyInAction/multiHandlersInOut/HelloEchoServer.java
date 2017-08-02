package work.wk.NettyInAction.multiHandlersInOut;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.ServerSocketChannel;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Created by wangkai43 on 2017/7/18.
 */
public class HelloEchoServer {

    public static void main(String[] args) {
        int port =8081;
        try {
            new HelloEchoServer().startServer(port);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void startServer(int port) throws Exception{

        EventLoopGroup fatherGroup = new NioEventLoopGroup();
        EventLoopGroup sonGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(fatherGroup, sonGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 120)
                    .childOption(ChannelOption.SO_KEEPALIVE,true)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel serverSocketChannel) throws Exception {
                            serverSocketChannel.pipeline().addLast(new ServerOutboundHandlerFirst());
                            serverSocketChannel.pipeline().addLast(new ServerOutboundHandlerSecond());

                            serverSocketChannel.pipeline().addLast(new ServerInboundHandlerFirst());
                            serverSocketChannel.pipeline().addLast(new ServerInboundHandlerSecond());

                        }
                    });
            ChannelFuture cf = bootstrap.bind(port);

          //  cf.channel().closeFuture().sync();
            cf.addListener(new ChannelFutureListener() {
                @Override
                public void operationComplete(ChannelFuture channelFuture) throws Exception {
                    if (channelFuture.isSuccess()) {
                        System.out.println("Channel bound");
                    } else {
                        System.err.println("Bind attempt failed");
                        channelFuture.cause().printStackTrace();
                    }
                }
            });
            cf.channel().closeFuture().sync();
        }finally {
            fatherGroup.shutdownGracefully();
            sonGroup.shutdownGracefully();
        }
    }

}
