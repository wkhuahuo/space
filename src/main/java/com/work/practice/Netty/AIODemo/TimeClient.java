package work.wk.Netty.AIODemo;

/**
 * Created by wangkai43 on 2017/7/9.
 */
public class TimeClient {
    public static void main(String[] args) {
        int port = 8080;
        String host = "127.0.0.1";
        AsycTimeClientHandler atc = new AsycTimeClientHandler(host,port);
        new Thread(atc,"TimeClient").start();
    }
}
