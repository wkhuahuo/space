package com.algorithm.batAlgorithm.probability;

/**
 * 链接：https://www.nowcoder.com/courses/1/10/2
 来源：牛客网

 有2k只球队，有k-1个强队，其余都是弱队，随机把它们分成k组比赛，每组两个队，问两强相遇的概率是多大？

 给定一个数k，请返回一个数组，其中有两个元素，分别为最终结果的分子和分母，请化成最简分数
 测试样例：

 4

 返回：[3,7]
 * Created by wkhuahuo on 19/02/17.
 */
public class Championship {
    public int[] calc(int k) {
        int m=1;
        int n=0;

        for(int i=2*k-1;i>0;i-=2){
            m *= i;
        }
        n = m-((k+1)*k/2*jiecheng(k-1));

        int tmp = GCD(n,m);
        int[] res = new int[2];

        res[0] = n/tmp;
        res[1] = m/tmp;
        return res;
    }
    private int jiecheng(int k){
        int result=1;
        for(int i=1;i<=k;i++){
            result *=i;
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
