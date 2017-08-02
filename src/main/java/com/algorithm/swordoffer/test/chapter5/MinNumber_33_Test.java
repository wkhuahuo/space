package com.algorithm.swordoffer.test.chapter5;

import com.algorithm.swordoffer.run.Chapter5.MinNumber_33;

/**
 * Created by wkhuahuo on 2017/3/26.
 */
public class MinNumber_33_Test {
    public static void main(String [] args){
        int[] numbres = {3,32,321};
        MinNumber_33 min = new MinNumber_33();
        String str =min.PrintMinNumber(numbres);
        System.out.println(str);
    }
}
