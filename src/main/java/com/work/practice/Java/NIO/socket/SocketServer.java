package work.wk.Java.NIO.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * Created by wangkai43 on 2017/7/3.
 */
public class SocketServer {
    public static void main(String[] args) {
        server();
    }
    public static void server(){
        ServerSocket serverSocket = null;
        InputStream in = null;
        try {
            serverSocket = new ServerSocket(8583);
            int recvMsgSize =0;
            byte[] recvBuf = new byte[1024];
            while(true){
                Socket clientSocket = serverSocket.accept();
                SocketAddress clientAddress = clientSocket.getRemoteSocketAddress();
                System.out.println("Handling client at "+clientAddress);
                in = clientSocket.getInputStream();
                while((recvMsgSize = in.read(recvBuf))!=-1){
                    byte[] temp = new byte[recvMsgSize];
                    System.arraycopy(recvBuf,0,temp,0,recvMsgSize);
                    System.out.println(new String(temp));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try{
                if(serverSocket !=null){
                    serverSocket.close();
                }
                if(in!=null){
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
