package com.work.practice.Java.enums;

import org.junit.Test;

/**
 * @author wangkai43
 * @create 2018-07-04-10:19
 * @email wangkai43@meituan.com
 */
public class EnumTest {

    @Test
    public void testextends(){
        double x= 3.3;
        double y = 2.0;
        test(ExtendedOperation.class, x, y);
        test(BasicOperation.class, x, y);
    }
    private static <T extends Enum<T> & Operation> void test(Class<T> opSet, double x, double y){
        for(Operation op : opSet.getEnumConstants()){
            System.out.printf("%f %s %f = %f%n",x ,op ,y ,op.apply(x,y));
        }
    }
}
