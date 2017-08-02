package com.work.practice.mianshi.classloading;

/**
 * 被动使用类字段演示之一：
 * 通过子类引用父类的静态字段，不会导致子类初始化。
 * Created by wkhuahuo on 2017/3/5.
 */
public class SuperClass {
    static {
        System.out.println("SuperClass init");
    }
    public static int value =123;
}
