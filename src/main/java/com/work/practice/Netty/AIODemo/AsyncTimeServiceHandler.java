package com.work.practice.Netty.AIODemo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.CountDownLatch;

/**
 * Created by wangkai43 on 2017/7/9.
 */
public class AsyncTimeServiceHandler implements Runnable{

    int port;
    AsynchronousServerSocketChannel assc ;
    CountDownLatch cdl ;

    public AsyncTimeServiceHandler(int port) throws IOException {
        this.port = port;
        assc = AsynchronousServerSocketChannel.open();
        assc.bind(new InetSocketAddress(port));
    }


    @Override
    public void run() {
        cdl = new CountDownLatch(1);
        doAccept();
        try {
            cdl.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void doAccept(){
        assc.accept(this,new AcceptCompletionHandler());
    }
}
