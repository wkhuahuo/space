package com.algorithm.batAlgorithm.probability;

/**
 * 链接：https://www.nowcoder.com/courses/1/10/3
 来源：牛客网

 n只蚂蚁从正n边形的n个定点沿着边移动，速度是相同的，问它们碰头的概率是多少？

 给定一个正整数n，请返回一个数组，其中两个元素分别为结果的分子和分母，请化为最简分数。
 测试样例：

 3

 返回：[3,4]
 * Created by wkhuahuo on 20/02/17.
 */
public class Ants {
    public int[] collision(int n) {

        int m = ncifang(n);
        int fenzi = m-2;

        int tmp =GCD(fenzi,m);

        int[] res = new int[2];
        res[0] = fenzi/tmp;
        res[1] = m/tmp;
        return res;
    }
    private int ncifang  (int n){
        int result =1;
        for(int i=0;i<n;i++){
            result *=2;
        }
        return result;
    }
    private int  GCD(int s,int b){
        int result =0;
        if(s>b){
            int tmp = b;
            b = s;
            s = tmp;
        }
        while(s!=0){
            result = b%s;
            b = s;
            s = result;
        }
        return b;
    }
}
