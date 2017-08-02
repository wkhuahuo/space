package com.algorithm.swordoffer.test;

import com.algorithm.swordoffer.run.Chapter4.StringArrangement_28;

import java.util.ArrayList;

/**
 * Created by wkhuahuo on 2017/3/24.
 */
public class StringArrangement_28Test {
    public static void main(String[] args){
        StringArrangement_28  strarr = new StringArrangement_28();
        String str = "abc";
        ArrayList<String> arrs = strarr.Permutation(str);
        System.out.println(arrs.toString());
    }
}
