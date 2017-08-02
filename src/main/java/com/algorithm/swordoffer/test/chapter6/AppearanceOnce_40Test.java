package com.algorithm.swordoffer.test.chapter6;

import com.algorithm.swordoffer.run.chapter6.AppearanceOnce_40;

/**
 * Created by wkhuahuo on 2017/3/27.
 */
public class AppearanceOnce_40Test {
    public static void main(String[] args){
        AppearanceOnce_40 ap = new AppearanceOnce_40();
        int[] arr ={4,6};
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        ap.FindNumsAppearOnce(arr,num1,num2);
        System.out.println(num1[0]+" "+num2[0]);
    }
}
