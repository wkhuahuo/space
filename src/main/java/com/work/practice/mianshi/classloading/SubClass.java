package com.work.practice.mianshi.classloading;

/**
 *被动使用类字段演示一：
 * 子类
 * Created by wkhuahuo on 2017/3/5.
 */
public class SubClass extends SuperClass{
    static {
        System.out.println("SubClass init!");
    }
}
