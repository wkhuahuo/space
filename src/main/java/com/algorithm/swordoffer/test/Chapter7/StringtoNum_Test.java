package com.algorithm.swordoffer.test.Chapter7;

import com.algorithm.swordoffer.run.Chapter7.StringtoNum;

/**
 * Created by wkhuahuo on 2017/3/30.
 */
public class StringtoNum_Test {
    public static void main(String[] args){
        StringtoNum strnum = new StringtoNum();
        String str = "e+6";
        char[] chars = str.toCharArray();
        boolean foo =strnum.isNumeric(chars);
        System.out.println(foo);
    }
}
