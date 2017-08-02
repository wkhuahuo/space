package com.algorithm.swordoffer.test.chapter5;

import com.algorithm.swordoffer.run.Chapter5.MinestK;

import java.util.ArrayList;

/**
 * Created by wkhuahuo on 2017/3/24.
 */
public class MinestK_30Test {
    public static void main(String[] args){
        MinestK min = new MinestK();
        int[] input = {4,5,1,6,2,7,3,8};
        int k = 4;
        ArrayList<Integer> arrayList= min.GetLeastNumbers_Solution(input,k);
        for(Integer i: arrayList){
            System.out.print(i+" ");
        }
    }
}
