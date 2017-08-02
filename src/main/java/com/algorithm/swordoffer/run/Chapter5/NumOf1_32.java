package com.algorithm.swordoffer.run.Chapter5;

/**
 * Created by wkhuahuo on 2017/3/26.
 */
public class NumOf1_32 {
    /***
     * 方法见https://discuss.leetcode.com/topic/18054/4-lines-o-log-n-c-java-python/2
     * 精彩！
     *
     */
    public int NumberOf1Between1AndN_Solution(int n) {
        int ones =0;
        for(int m = 1;m<=n;m*=10){
            int a =n/m, b = n%m;
            ones +=(a+8)/10 * m + (a%10 == 1? b+1: 0);

        }

        return ones;

    }

}
