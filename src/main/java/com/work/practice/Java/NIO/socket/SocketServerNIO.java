package com.work.practice.Java.NIO.socket;

import com.sun.org.apache.bcel.internal.generic.Select;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by wangkai43 on 2017/7/3.
 */
public class SocketServerNIO {
    private static final int BUF_SIZE = 1024;
    private static final int PORT = 8583;
    private static final int TIMEOUT =3000;

    public static void main(String[] args) {
        selector();
    }

    public static void selector() {
        Selector selector = null;
        ServerSocketChannel ssc = null;
        try {
            selector =Selector.open();
            ssc = ServerSocketChannel.open();
            ssc.configureBlocking(false);
            ssc.socket().bind(new InetSocketAddress(PORT));
            ssc.register(selector, SelectionKey.OP_ACCEPT);

            while(true){
                if(selector.select(TIMEOUT) == 0){//阻塞直到超时或者有事件发生。
                    System.out.println("==");
                    continue;
                }
                Set<SelectionKey> iters = selector.selectedKeys();
                Iterator<SelectionKey> iter = iters.iterator();
                while(iter.hasNext()){
                    SelectionKey key = iter.next();
                    if(key.isAcceptable()){
                        handleAccept(key);
                    }
                    if(key.isReadable()){
                        handleRead(key);
                    }
                    if(key.isWritable() && key.isValid()){
                        handleWrite(key);
                    }
                    if(key.isConnectable()){

                    }
                    iter.remove();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try{
                if(selector !=null){
                    selector.close();
                }
                if(ssc!=null){
                    ssc.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void handleAccept(SelectionKey key) throws IOException{
        ServerSocketChannel ssChannel = (ServerSocketChannel) key.channel();//得到ServerSocketChannel
        SocketChannel sc = ssChannel.accept();//非阻塞，接受连接。
        sc.configureBlocking(false);//设置通道为非阻塞
        sc.register(key.selector(),SelectionKey.OP_READ, ByteBuffer.allocateDirect(BUF_SIZE));
        //把该Channel注册到seleocor中。设置事件类型为读，设置缓冲区attachment。
    }

    public static void handleRead(SelectionKey key) throws IOException{
        SocketChannel sc = (SocketChannel) key.channel();
        ByteBuffer buf = (ByteBuffer) key.attachment();//attachment为register函数的第三个参数
        long bytesRead = sc.read(buf);
        while(bytesRead>0){
            buf.flip();
            while(buf.hasRemaining()){
                System.out.print(buf.getChar());
            }
            System.out.println();
            buf.clear();
            bytesRead = sc.read(buf);
        }
        if(bytesRead == -1){
            sc.close();
        }
    }

    public static void handleWrite(SelectionKey key) throws IOException{
        ByteBuffer buf = (ByteBuffer) key.attachment();
        buf.flip();
        SocketChannel sc = (SocketChannel) key.channel();
        while(buf.hasRemaining()){
            sc.write(buf);
        }
        buf.compact();
    }

}
