package com.work.practice.Java.annotation.timeCost;

/**
 * @author wangkai43
 * @create 2018-10-30-19:07
 * @email wangkai43@meituan.com
 */
public class Hello {

    @TimeCost
    public void sayHello () {
        System.out.println("Hello");
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void sayBye() {
        System.out.println("Bye");
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }




}
