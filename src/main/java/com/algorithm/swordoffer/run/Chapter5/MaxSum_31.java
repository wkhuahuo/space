package com.algorithm.swordoffer.run.Chapter5;

/**
 * Created by wkhuahuo on 2017/3/25.
 */
public class MaxSum_31 {
    public int FindGreatestSumOfSubArray(int[] array) {
        if(array == null || array.length == 0){
            return Integer.MIN_VALUE;
        }
        int max =array[0];
        int sum = 0;

        for(int i=0;i<array.length;i++){
            sum+=array[i];
            if(sum>max){
                max = sum ;
            }
            if(sum<0){
                sum = 0;
            }
        }

        return max;
    }
}
