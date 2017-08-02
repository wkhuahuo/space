package work.wk.Netty.NIODemo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by wangkai43 on 2017/7/7.
 */
public class TimeClientHandle implements Runnable {

    private String host;
    private int port;
    private Selector selector;
    private SocketChannel socketChannel;
    private volatile boolean stop=false;

    public TimeClientHandle(String host,int port) {
        this.host = host == null?"127.0.0.1":host;
        this.port = port;
        try {
            selector = Selector.open();
            socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {

        try {
            doConnect();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("doConnect failed");
            System.exit(1);
        }
        while (!stop){
            System.out.println("selector select");
            try {
                selector.select(1000);
                Set<SelectionKey> keys = selector.selectedKeys();
                Iterator<SelectionKey> it = keys.iterator();
                SelectionKey key = null;
                while(it.hasNext()){
                    key = it.next();
                    if(key.isValid()){
                        try {
                            handleInput(key);
                        }catch (IOException e){
                            if(key!=null){
                                key.cancel();
                            }
                            if(key.channel()!=null){
                                key.channel().close();
                            }
                            e.printStackTrace();
                        }
                    }
                    it.remove();
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(1);
            }
          //  this.stop = true;
        }
    }

    private void handleInput(SelectionKey key) throws IOException{
        if(key.isValid()){
            SocketChannel sc = (SocketChannel) key.channel();
            if(key.isConnectable()){
                if(sc.finishConnect()){
                    sc.register(selector, SelectionKey.OP_READ);
                    doWrite(sc);
                }else{
                    System.exit(1);
                }

            }
            if(key.isReadable()){
                ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                int readBytes = sc.read(byteBuffer);
                if(readBytes >0){
                    byteBuffer.flip();
                    byte[] bytes = new byte[byteBuffer.remaining()];
                    byteBuffer.get(bytes);
                    String body = new String(bytes);
                    System.out.println("Now is :"+body);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    doWrite(sc);
                //    stop();
                }else if(readBytes < 0){
                    key.cancel();
                    sc.close();
                }else if(readBytes ==0){

                }

            }



        }
    }

    public void stop(){
        this.stop = true;
    }

    private void doConnect() throws IOException {
        if(socketChannel.connect(new InetSocketAddress(host,port))){
            socketChannel.register(selector, SelectionKey.OP_READ);
            doWrite(socketChannel);
        }else{
            socketChannel.register(selector,SelectionKey.OP_CONNECT);
        }
    }
    private void doWrite(SocketChannel socketChannel) throws IOException {
        byte[] rq = "QUERY TIME ORDER".getBytes();
        ByteBuffer writeBuffer = ByteBuffer.allocate(rq.length);
        writeBuffer.put(rq);
        writeBuffer.flip();
        socketChannel.write(writeBuffer);
        if(!writeBuffer.hasRemaining()){
            System.out.println("Send Order 2 Server succeed");
        }

    }

}
