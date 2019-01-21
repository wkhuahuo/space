package com.work.practice.Java.annotation.timeCost;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author wangkai43
 * @create 2018-10-30-19:08
 * @email wangkai43@meituan.com
 */
public class HelloTest {

    public static void main(String[] args) {
        String className = "com.work.practice.Java.annotation.timeCost.Hello";

        try {
            Class  cls = Class.forName(className);
            Object obj = cls.newInstance();
            Method[] methods =  cls.getDeclaredMethods();
            for(Method method : methods) {
                if(method.isAnnotationPresent(TimeCost.class)){
                    method.setAccessible(true);
                    long start = System.currentTimeMillis();
                    method.invoke(obj);
                    long end = System.currentTimeMillis();
                    System.out.println("--> 执行时间:"+(end - start));
                }else {
                    method.invoke(obj);
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
