package com.algorithm.batAlgorithm.dynamicprogramming;

/**
 * 有n级台阶，一个人每次上一级或者两级，问有多少种走完n级台阶的方法。为了防止溢出，请将结果Mod 1000000007
 给定一个正整数int n，请返回一个数，代表上楼的方式数。保证n小于等于100000。
 * Created by wkhuahuo on 2017/2/28.
 */
public class GoUpstairs {
        public int countWays1(int n) {
            if(n==1){
                return 1;
            }
            if(n==2){
                return 2;
            }
            return countWays1(n-1)%1000000007+countWays1(n-2)%1000000007;
        }
    public int countWays(int n) {
        if (n == 1) {
            return 1;
        }
        if (n==2) {
            return 2;
        }
        int result=0;
        int tmpb =1;
        int tmpl =2;
        for(int i=3;i<=n;i++){
            result =tmpb+tmpl;
            result %= 1000000007;
            tmpb = tmpl;
            tmpl = result;

        }
        return result;
    }
    }
