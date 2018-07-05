package com.algorithm.lintCode.run;

/**
 * @author wangkai43
 * @create 2017-09-05-18:37
 * @email wangkai43@meituan.com
 */
public class ClimbStairs {
    /**
     * @param n: An integer
     * @return: An integer
     */
    public int climbStairs(int n) {
        // write your code here
        if(n <= 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }

        return climbStairs(n-1)+climbStairs(n-2);
    }

    public int climbStairs2(int n){
        if(n <= 0){
            return 1;
        }
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }

        int pre =2;
        int prepre =1;
        int now = pre +prepre;

        while (n>3){
            prepre = pre;
            pre = now;
            now = pre+prepre;
            n--;
        }

        return now;
    }
}
