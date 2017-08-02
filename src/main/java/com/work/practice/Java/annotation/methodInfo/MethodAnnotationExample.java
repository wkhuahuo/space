package com.work.practice.Java.annotation.methodInfo;

/**
 * Created by wangkai43 on 2017/6/21.
 */
public class MethodAnnotationExample {

    @Override
    @MethodInfo(author = "Pankaj", comments = "Main method", date = "Nov 17 2012", version = 1)
    public String toString() {
        return "Overriden toString method";
    }


    @MethodInfo(comments = "deprecated method", date = "Nov 17 2012")
    public static void oldMethod() {
        System.out.println("old method, don't use it.");
    }


}
