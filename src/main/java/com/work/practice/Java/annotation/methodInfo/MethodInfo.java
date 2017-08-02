package com.work.practice.Java.annotation.methodInfo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by wangkai43 on 2017/6/21.
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodInfo {
    public String author() default "practice";
    public String date();
    public int version() default 1;
    public String comments();
}
