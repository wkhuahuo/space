package com.algorithm.swordoffer.test.chapter5;

import com.algorithm.swordoffer.run.Chapter5.MoreThanHalf_29;

/**
 * Created by wkhuahuo on 2017/3/24.
 */
public class MoreThanHalf_29Test {
    public static void main(String[] args){
        MoreThanHalf_29 moreThanHalf_29 = new MoreThanHalf_29();
        int[] arr = {1,2,3,2,4,2,5,2,3};
        int result = moreThanHalf_29.MoreThanHalfNum_Solution(arr);
        System.out.println(result);
    }
}
