package com.work.practice.Java.util_package;

import java.util.BitSet;

/**
 * @author wangkai43
 * @create 2017-08-07-10:27
 * @email wangkai43@meituan.com
 */
public class BitMapDemo {
    public static void main(String[] args) {
        byte[] bytemap = {0x02,0x01,0x02};

        BitSet bitSet =BitSet.valueOf(bytemap);
        String str =bitSet.toString();

        System.out.println(str);
    }
}
