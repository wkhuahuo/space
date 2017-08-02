package com.algorithm.swordoffer.test.chapter6;

import com.algorithm.swordoffer.run.chapter6.ReverseStr_42;

/**
 * Created by wkhuahuo on 2017/3/26.
 */
public class ReverseStr_42Test {
    public static void main(String[] args){
        ReverseStr_42 rever = new ReverseStr_42();
        //String str = "  ";
        String str = "I am a Student.";
        String strR = rever.ReverseSentence(str);
        System.out.println(strR);
    }
}
