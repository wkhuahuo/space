package com.algorithm.batAlgorithm.bitOperation;

/**
 *
 请编写一个算法，不用任何额外变量交换两个整数的值。
 给定一个数组num，其中包含两个值，请不用任何额外变量交换这两个值，并将交换后的数组返回。
 测试样例：
 [1,2]
 返回：
 [2,1]
 * Created by wkhuahuo on 17/02/17.
 */
public class Swap {
    public int[] getSwap(int[] num) {//变量
        int tmp=num[0];
        num[0] = num[1];
        num[1] = tmp;
        return num;
    }
    public int[] getSwap2(int[] num) {//纯算术
        num[0] = num[0]-num[1];
        num[1] = num[1]+num[0];
        num[0] = num[1]-num[0];
        return num;
    }
    public int[] getSwap1(int[] num){//位运算
        num[1] = num[0]^num[1];
        num[0] = num[0]^num[1];
        num[1] = num[0]^num[1];
        return num;
    }
}
