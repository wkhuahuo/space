package com.work.practice.NettyInAction.multiHandlersInOut;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.logging.Logger;

/**
 * Created by wangkai43 on 2017/7/18.
 */
public class ServerInboundHandlerSecond extends ChannelInboundHandlerAdapter {

    private static Logger logger = Logger.getLogger(ServerInboundHandlerSecond.class.getName());

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println(System.currentTimeMillis()+"ServerInboundHandlerSecond.channelRead : ctx "+ctx);
        ByteBuf result = (ByteBuf)msg;
        byte[] echomsg = new byte[result.readableBytes()];
        result.readBytes(echomsg);
        String echomsgstr = new String(echomsg);
        System.out.println("Client said: "+echomsgstr);
        result.release();
        ctx.write(msg);

    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        System.out.println(System.currentTimeMillis()+"ServerInboundHandlerSecond.channelReadComplete ");
       // ctx.fireChannelReadComplete();
        ctx.flush();
    }
}
