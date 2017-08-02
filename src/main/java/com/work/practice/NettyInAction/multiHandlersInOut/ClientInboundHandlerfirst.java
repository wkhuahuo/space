package com.work.practice.NettyInAction.multiHandlersInOut;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.logging.Logger;

/**
 * Created by wangkai43 on 2017/7/18.
 */
public class ClientInboundHandlerfirst extends ChannelInboundHandlerAdapter {

    private static Logger logger = Logger.getLogger(ClientInboundHandlerfirst.class.getName());
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("HelloClientIntHandler.channelActive");
        String msg = "Are you OK?";
        ByteBuf encode = ctx.alloc().buffer(msg.length());
        encode.writeBytes(msg.getBytes());
        ctx.write(encode);
        ctx.flush();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("ClientInboundHandlerfirst.channelRead");
        ByteBuf result = (ByteBuf)msg;
        byte[] echomsg = new byte[result.readableBytes()];
        result.readBytes(echomsg);
        String str = new String(echomsg);
        result.release();
        ctx.close();
        System.out.println("Server said: "+str);
    }
}
