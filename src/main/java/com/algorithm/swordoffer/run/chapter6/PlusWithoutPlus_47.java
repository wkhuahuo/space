package com.algorithm.swordoffer.run.chapter6;

/**
 * Created by wkhuahuo on 2017/3/28.
 */
public class PlusWithoutPlus_47 {
    public int Add(int num1,int num2) {
        int sum=0;
        int tmpsum = num1^num2;
        sum = (num1&num2)<<1;
        sum +=tmpsum;
        return sum;
    }
}
