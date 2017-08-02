package com.work.practice.NettyInAction.multiHandlersInOut;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;

import java.util.logging.Logger;

/**
 * Created by wangkai43 on 2017/7/18.
 */
public class ServerOutboundHandlerSecond extends ChannelOutboundHandlerAdapter {

    private static Logger logger = Logger.getLogger(ServerOutboundHandlerFirst.class.getName());

    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        System.out.println(System.currentTimeMillis()+"ServerOutboundHandlerSecond.write : ctx "+ctx);
      /*  ByteBuf response = (ByteBuf)msg;
        byte[] tmp = new byte[response.readableBytes()];
        response.readBytes(tmp);
        String tmpmsg = new String(tmp);

        System.out.println("Hello "+tmpmsg);
        response.resetReaderIndex();
*/
        super.write(ctx, msg, promise);
    }
}
