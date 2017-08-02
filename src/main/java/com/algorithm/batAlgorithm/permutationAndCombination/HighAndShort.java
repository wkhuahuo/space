package com.algorithm.batAlgorithm.permutationAndCombination;

/**
 * 链接：https://www.nowcoder.com/courses/1/9/11
 来源：牛客网

 12个高矮不同的人，排成两排，每排必须是从矮到高排列，而且第二排比对应的第一排的人高，问排列方式有多少种？

 给定一个偶数n，请返回所求的排列方式个数。保证结果在int范围内。
 测试样例：

 1

 返回：1
 * Created by wkhuahuo on 18/02/17.
 */
public class HighAndShort {
    public int countWays(int n) {
        //同BuyTickets

            int sum=1;
            for(int i=n;i>n/2;i--){
                sum *=i;
            }
            for(int i=n/2;i>0;i--){
                sum /=i;
            }
            sum /=n/2+1;
            return sum;

    }
}
