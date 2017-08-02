package com.algorithm.batAlgorithm.permutationAndCombination;

/**
 *

 n颗相同的糖果，分给m个人，每人至少一颗，问有多少种分法。

 给定n和m，请返回方案数，保证n小于等于12，且m小于等于n。
 测试样例：

 10,3

 返回：36


 * Created by wkhuahuo on 18/02/17.
 */
public class Distribution {
    public int getWays(int n, int m){
        int sum=1;
        n -=1;
        m -=1;
        for(int i=n;i>n-m;i--){
            sum *= i;
        }
        for(int i=m;i>0;i--){
            sum/=i;
        }
        return sum;
    }
    private int factorial(int n){
        int sum =1;
        for(int i=1;i<=n;i++){
            sum *= i;
        }
        return sum;
    }
}
