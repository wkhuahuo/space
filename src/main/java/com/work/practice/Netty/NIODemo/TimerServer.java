package com.work.practice.Netty.NIODemo;

/**
 * Created by wangkai43 on 2017/7/6.
 */
public class TimerServer {
    public static void main(String[] args) {
        int port = 8080;
        MultiplexerTimerServer timerServer = new MultiplexerTimerServer(port);
        new Thread(timerServer,"NIO-MultiplexerTimerServer-001").start();
    }
}
