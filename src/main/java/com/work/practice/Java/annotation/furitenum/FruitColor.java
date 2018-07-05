package com.work.practice.Java.annotation.furitenum;

import java.lang.annotation.*;

/**
 * @author wangkai43
 * @create 2018-01-17-21:24
 * @email wangkai43@meituan.com
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitColor {

    public enum Color {BLUE, RED, GREEN};

    Color fruitColor() default Color.GREEN;
}
