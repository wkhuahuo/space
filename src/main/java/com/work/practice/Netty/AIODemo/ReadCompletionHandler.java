package com.work.practice.Netty.AIODemo;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.Date;

/**
 * Created by wangkai43 on 2017/7/9.
 */
public class ReadCompletionHandler implements CompletionHandler<Integer,ByteBuffer>{
    private AsynchronousSocketChannel channel;

    public ReadCompletionHandler(AsynchronousSocketChannel result) {
        this.channel = result;
    }

    @Override
    public void completed(Integer result, ByteBuffer attachment) {
        attachment.flip();
        byte[] body = new byte[attachment.remaining()];
        attachment.get(body);
        try{
            String req = new String(body,"UTF-8");
            System.out.println("The time server receive order: "+ req);
            String currenttime = "QUERY TIME ORDER".equals(req)? new Date(System.currentTimeMillis()).toString():"BAD ORDER";
            doWrite(currenttime);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    private void doWrite(String currenttime) {
        if(currenttime !=null && currenttime.length()>0){
            byte[] bytes = (currenttime).getBytes();
            ByteBuffer writeBb = ByteBuffer.allocate(bytes.length);
            writeBb.put(bytes);
            writeBb.flip();
            channel.write(writeBb, writeBb, new CompletionHandler<Integer, ByteBuffer>() {
                @Override
                public void completed(Integer result, ByteBuffer attachment) {
                    if(attachment.hasRemaining()){
                        channel.write(attachment,attachment,this);
                    }
                }

                @Override
                public void failed(Throwable exc, ByteBuffer attachment) {
                    try {
                        channel.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    @Override
    public void failed(Throwable exc, ByteBuffer attachment) {
        try {
            this.channel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
