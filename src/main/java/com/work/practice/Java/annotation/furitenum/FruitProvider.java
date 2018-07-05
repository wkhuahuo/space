package com.work.practice.Java.annotation.furitenum;

import java.lang.annotation.*;

/**
 * Created by wangkai43 on 2018/1/17.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitProvider {
    public int id() default -1;
    public String name() default "wk";
    public String address() default "huahuo";
}
