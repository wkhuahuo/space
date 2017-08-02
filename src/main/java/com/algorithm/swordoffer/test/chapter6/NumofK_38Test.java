package com.algorithm.swordoffer.test.chapter6;

import com.algorithm.swordoffer.run.chapter6.NumofK_38;

/**
 * Created by wkhuahuo on 2017/3/27.
 */
public class NumofK_38Test {
    public static void main(String[] args){
        NumofK_38 numofK = new NumofK_38();
        int[] array = {1,2,3,3,3,3};
        int num = numofK.GetNumberOfK(array,3);
        System.out.println(num);
    }
}
