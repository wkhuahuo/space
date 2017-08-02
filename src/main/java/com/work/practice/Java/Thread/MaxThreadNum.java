package com.work.practice.Java.Thread;

/**
 * Created by wangkai43 on 2017/7/12.
 */
public class MaxThreadNum {

    private static Object s = new Object();
    private static int count = 0;
    public static void main(String[] args) {
        for(;;){
            new Thread(new Runnable(){
                public void run(){
                    synchronized(s){
                        count += 1;
                        System.err.println("New thread #"+count);
                    }
                    for(;;){
                        try {
                            Thread.sleep(1000);
                        } catch (Exception e){
                            System.err.println(e);
                        }
                    }
                }
            }).start();
        }
       /* long count=0;
        long cc=0;

        for(;;){
            if(count>Long.MAX_VALUE-1){
                count = 1;
                cc++;
            }
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                    boolean[] space =new boolean[2048];
                  //  boolean[] space =new boolean[1024];

                    try {
                        Thread.sleep((10000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }, "线程： "+cc+":"+count++).start();*/



    }
}
