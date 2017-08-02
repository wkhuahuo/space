package com.work.practice.mianshi.designmodel;



import java.io.*;

/**
 * 饿汉式创建实例对象
 * 线程安全
 *
 * Created by wkhuahuo on 2017/3/5.
 */
public class Singleton_static2 implements Serializable {
    private static Singleton_static2 singleton_static2 = new Singleton_static2();

    private Singleton_static2() {
        //通过抛异常防止反射
        if (null != Singleton_static2.singleton_static2) {
            System.out.println("Exception");
            throw new RuntimeException();
        }
    }
    public static  Singleton_static2 getInstance(){
        return singleton_static2;
    }

    // 防止反序列化获取多个对象的漏洞  
  /*  private Object readResolve() throws ObjectStreamException {
        return Singleton_static2.singleton_static2;
    }*/
    private Object readResolve() {
        return singleton_static2;
    }

}


