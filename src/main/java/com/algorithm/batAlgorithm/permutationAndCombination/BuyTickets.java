package com.algorithm.batAlgorithm.permutationAndCombination;

/**
 * 链接：https://www.nowcoder.com/courses/1/9/9
 来源：牛客网

 2n个人排队买票，n个人拿5块钱，n个人拿10块钱，票价是5块钱1张，每个人买一张票，售票员手里没有零钱，问有多少种排队方法让售票员可以顺利卖票。

 给定一个整数n，请返回所求的排队方案个数。保证结果在int范围内。
 测试样例：

 1

 返回：1
 * Created by wkhuahuo on 18/02/17.
 */
public class BuyTickets {
    public int countWays(int n){
        int sum=1;
        for(int i=2*n;i>n;i--){
            sum *=i;
        }
        for(int i=n;i>0;i--){
            sum /=i;
        }
        sum /=n+1;
        return sum;
    }
}
