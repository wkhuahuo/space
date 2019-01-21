package com.work.practice.Java.annotation.timeCost;

import java.lang.annotation.*;

/**
 * Created by wangkai43 on 2018/10/30.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TimeCost {

}
