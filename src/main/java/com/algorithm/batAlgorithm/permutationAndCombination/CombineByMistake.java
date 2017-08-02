package com.algorithm.batAlgorithm.permutationAndCombination;

/**
 * 链接：https://www.nowcoder.com/courses/1/9/12
 来源：牛客网

 有n个信封，包含n封信，现在把信拿出来，再装回去，要求每封信不能装回它原来的信封，问有多少种装法?

 给定一个整数n，请返回装发个数，为了防止溢出，请返回结果Mod 1000000007的值。保证n的大小小于等于300。
 测试样例：

 2

 返回：1
 * Created by wkhuahuo on 18/02/17.
 */
public class CombineByMistake {
    public int countWays(int n) {
        if(n==1){
            return 0;
        }
        if(n==2){
            return 1;
        }else {
            long pre = 0;
            long last = 1;
            long result = 0;
            for (int i = 3; i <= n; i++) {
                result = ((i - 1) * (pre + last)) % 1000000007;
                pre = last;
                last = result;

            }
            return (int) result;
        }

    }


}
