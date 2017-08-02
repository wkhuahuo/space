package com.algorithm.batAlgorithm.permutationAndCombination;

/**
 * 链接：https://www.nowcoder.com/courses/1/9/7
 来源：牛客网

 假设有n对左右括号，请求出合法的排列有多少个？合法是指每一个括号都可以找到与之配对的括号，比如n=1时，()是合法的，但是)(为不合法。

 给定一个整数n，请返回所求的合法排列数。保证结果在int范围内。
 测试样例：

 1

 返回：1
 * Created by wkhuahuo on 18/02/17.
 */
public class Parenthesis {
    public int countLegalWays(int n) {

        int sum = 1;
        for(int i=2*n;i>n;i--){
            sum *= i;
        }
        for(int i=n;i>0;i--){
            sum /=i;
        }
        sum /=(n+1);


        return sum;
    }
}
