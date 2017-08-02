package com.work.practice.Netty.AIODemo;

import java.io.IOException;

/**
 * Created by wangkai43 on 2017/7/9.
 */
public class TimeServer {
    public static void main(String[] args) {
        int port=8080;
        try {
            AsyncTimeServiceHandler assc =new AsyncTimeServiceHandler(port);
            new Thread(assc,"TimeServer").start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
