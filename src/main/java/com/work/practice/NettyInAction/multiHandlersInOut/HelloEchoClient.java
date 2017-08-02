package work.wk.NettyInAction.multiHandlersInOut;


import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * Created by wangkai43 on 2017/7/18.
 */
public class HelloEchoClient {

    public static void main(String[] args) {
        String host = "127.0.0.1";
        int port =8081;
        try {
            new HelloEchoClient().startClient(host,port);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void startClient(String host, int port) throws InterruptedException {
        EventLoopGroup bossGroup = new NioEventLoopGroup();

        try {


            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(bossGroup)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.SO_KEEPALIVE, true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(new ClientInboundHandlerfirst());
                        }
                    });
            ChannelFuture f = bootstrap.connect(host, port).sync();
            f.channel().closeFuture().sync();
            /*f.addListener(new ChannelFutureListener() {
                @Override
                public void operationComplete(ChannelFuture channelFuture) throws Exception {
                    if(channelFuture.isSuccess()){
                        System.err.println("Connect success");
                    }else{
                        System.err.println("Connect attempt failed");
                        channelFuture.cause().printStackTrace();
                    }
                }
            });*/
        }finally {
            bossGroup.shutdownGracefully();
        }

    }
}
