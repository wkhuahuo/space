package com.work.practice.Java.dynamicparameters;

/**
 * Created by wangkai43 on 2017/7/21.
 */
public class FirstDemo {

    public static void main(String[] args) {
        test();
        test("aaa");
        test("aaa", "bbb");
        test("aaa", "bbb", "ccc");
        String[] strs = {"bbb", "ccc", "aaa"};
        test(strs);
    }

    public static void test(String... args) {
        System.out.println("------"+args.getClass()+"-----------");
        for (String arg : args) {
            System.out.println(arg);
        }
    }


}
