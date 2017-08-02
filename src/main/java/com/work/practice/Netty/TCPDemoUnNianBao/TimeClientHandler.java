package work.wk.Netty.TCPDemoUnNianBao;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import work.wk.Netty.NIODemo.TimeClientHandle;

import java.util.logging.Logger;

/**
 * Created by wangkai43 on 2017/7/14.
 */
public class TimeClientHandler extends ChannelInboundHandlerAdapter {

    private static final Logger logger = Logger.getLogger(TimeClientHandle.class.getName());
    private int counter;
    private byte[] req;

    public TimeClientHandler(){
        req =("QUERY TIME ORDER"+ System.getProperty("line.separator")).getBytes();
    }
    @Override
    public void channelActive(ChannelHandlerContext ctx){
        ByteBuf message = null;
        for(int i=0;i<100;i++){

            message = Unpooled.buffer(req.length);
            message.writeBytes(req);
            ctx.writeAndFlush(message);
        }
    }
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception{
        String body = (String) msg;
        System.out.println("Now is: "+body+"; the counter si: "+ ++counter);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause){
        logger.warning("Unexpected exception from downstream: "+ cause.getMessage());
        ctx.close();
    }
}
