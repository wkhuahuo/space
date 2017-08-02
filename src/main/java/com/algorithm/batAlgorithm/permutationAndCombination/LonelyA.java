package com.algorithm.batAlgorithm.permutationAndCombination;

/**
 * 链接：https://www.nowcoder.com/courses/1/9/4
 来源：牛客网

 A(A也是他的编号)是一个孤傲的人，在一个n个人(其中编号依次为1到n)的队列中，他于其中的标号为b和标号c的人都有矛盾，所以他不会和他们站在相邻的位置。现在问你满足A的要求的对列有多少种？

 给定人数n和三个人的标号A,b和c，请返回所求答案，保证人数小于等于11且大于等于3。
 测试样例：

 6,1,2,3

 288
 * Created by wkhuahuo on 18/02/17.
 */
public class LonelyA {
    public int getWays(int n, int A, int b, int c) {
        int num = 0;
        num = factorial(n)-2*factorial(n-1)-2*factorial(n-1)+2*factorial(n-2);

        return num;
    }
    private int factorial(int n){
        int sum =1;
        for(int i=1;i<=n;i++){
            sum *= i;
        }
        return sum;
    }
}
