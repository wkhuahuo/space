package com.algorithm.swordoffer.test.chapter5;

import com.algorithm.swordoffer.run.Chapter5.NumOf1_32;

/**
 * Created by wkhuahuo on 2017/3/26.
 */
public class NumOf1_32Test {
    public static void main(String[] args){
        NumOf1_32 num = new NumOf1_32();
        int nums = num.NumberOf1Between1AndN_Solution(723456);
        System.out.println(nums);
    }
}
