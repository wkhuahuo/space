package com.algorithm.swordoffer.test.chapter5;

import com.algorithm.swordoffer.run.Chapter5.InversePairsNum_36;

/**
 * Created by wkhuahuo on 2017/3/27.
 */
public class InversePairsNum_36Test {
    public static void main(String[] args){
        InversePairsNum_36 inverse = new InversePairsNum_36();
        int[] input = {1,2,3,4,5,6,7,0};
       int num = inverse.InversePairs(input);
       System.out.println( num);
    }
}
