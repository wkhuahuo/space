package com.work.practice.NettyInAction.multiHandlersInOut;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.logging.Logger;

/**
 * Created by wangkai43 on 2017/7/18.
 */
public class ServerInboundHandlerFirst extends ChannelInboundHandlerAdapter {

    private static Logger logger = Logger.getLogger(ServerInboundHandlerFirst.class.getName());
    private static int count=0;
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println(System.currentTimeMillis()+"ServerInboundHandlerFirst.channelRead: ctx "+ctx);
        ctx.fireChannelRead(msg);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        System.out.println(System.currentTimeMillis()+"ServerInboundHandlerFirst.channelReadComplete");

        ctx.flush();
//        System.out.println("==+=="+count++);
//        ctx.fireChannelReadComplete();
    }
}
