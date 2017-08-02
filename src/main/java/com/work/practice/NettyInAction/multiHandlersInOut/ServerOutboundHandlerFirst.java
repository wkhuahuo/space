package work.wk.NettyInAction.multiHandlersInOut;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;

import java.util.logging.Logger;

/**
 * Created by wangkai43 on 2017/7/18.
 */
public class ServerOutboundHandlerFirst extends ChannelOutboundHandlerAdapter {

    private static Logger logger = Logger.getLogger(ServerOutboundHandlerFirst.class.getName());

    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        System.out.println(System.currentTimeMillis()+"ServerOutboundHandlerFirst.write :ctx= "+ctx);
        String response ="I'm OK!" ;
        ByteBuf encode = ctx.alloc().buffer(4*response.length());

        encode.writeBytes(response.getBytes());
        ctx.write(encode);
        ctx.flush();

    }
}
