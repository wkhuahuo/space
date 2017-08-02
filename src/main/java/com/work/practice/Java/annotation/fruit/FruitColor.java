package com.work.practice.Java.annotation.fruit;

import java.lang.annotation.*;

/**
 * Created by wangkai43 on 2017/6/21.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitColor {

    String color() default "red";
}
