package com.work.practice.Java.annotation.furitenum;

import java.lang.annotation.*;

/**
 * @author wangkai43
 * @create 2018-01-17-21:21
 * @email wangkai43@meituan.com
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitName {
    String value() default "wkhuahuo";
}
