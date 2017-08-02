package work.wk.Netty.AIODemo;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;

import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.CountDownLatch;

/**
 * Created by wangkai43 on 2017/7/9.
 */
public class AsycTimeClientHandler implements CompletionHandler<Void,AsycTimeClientHandler>,Runnable{
    int port;
    String host;
    AsynchronousSocketChannel asynclient;
    private CountDownLatch latch;

    public AsycTimeClientHandler(String host, int port) {
        this.port = port;
        this.host = host;
        try {
            asynclient = AsynchronousSocketChannel.open();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        latch = new CountDownLatch(1);

        asynclient.connect(new InetSocketAddress(host,port),this,this);

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            asynclient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void completed(Void result, AsycTimeClientHandler attachment) {
        byte[] bytes = "QUERY TIME ORDER".getBytes();
        final ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
        writeBuffer.put(bytes);
        writeBuffer.flip();
        asynclient.write(writeBuffer, writeBuffer, new CompletionHandler<Integer, ByteBuffer>() {
            @Override
            public void completed(Integer result, final ByteBuffer buffer) {
                if(buffer.hasRemaining()){
                    asynclient.write(buffer,writeBuffer,this);

                }else {
                    ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                    asynclient.read(readBuffer, readBuffer, new CompletionHandler<Integer, ByteBuffer>() {
                        @Override
                        public void completed(Integer result, ByteBuffer bufferbyte) {
                            bufferbyte.flip();
                            byte[] bytes = new byte[bufferbyte.remaining()];
                            bufferbyte.get(bytes);

                            String body;
                            try{
                                body = new String(bytes,"UTF-8");
                                System.out.println("Now is: "+body);
                                latch.countDown();
                            } catch (UnsupportedEncodingException e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void failed(Throwable exc, ByteBuffer attachment) {
                            try {
                                asynclient.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            latch.countDown();
                        }
                    });
                }

            }

            @Override
            public void failed(Throwable exc, ByteBuffer attachment) {
                try {
                    asynclient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                latch.countDown();
            }
        });
    }

    @Override
    public void failed(Throwable exc, AsycTimeClientHandler attachment) {
        exc.printStackTrace();
        try {
            asynclient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        latch.countDown();
    }
}
