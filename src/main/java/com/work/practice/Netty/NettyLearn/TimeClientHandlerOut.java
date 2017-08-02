package com.work.practice.Netty.NettyLearn;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;

/**
 * Created by wangkai43 on 2017/7/14.
 */
public class TimeClientHandlerOut extends ChannelOutboundHandlerAdapter {
    ByteBuf firstMessage;
    public TimeClientHandlerOut(){
        System.out.println("TimeClientHandlerOut:构造方法");

    }

    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        super.write(ctx, msg, promise);


        ctx.writeAndFlush(firstMessage);
        System.out.println("msg.toString():"+msg.toString());

    }

    @Override
    public void read(ChannelHandlerContext ctx) throws Exception {
        super.read(ctx);
        byte[] req = "QUERY TIME ORDER".getBytes();
        firstMessage = Unpooled.buffer(req.length);
        ctx.writeAndFlush(firstMessage);
        System.out.println("read:");
    }
}
