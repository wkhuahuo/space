package com.algorithm.batAlgorithm.dynamicprogramming;

/**
 * 对于两个字符串A和B，我们需要进行插入、删除和修改操作将A串变为B串，
 * 定义c0，c1，c2分别为三种操作的代价，请设计一个高效算法，求出将A串变为B串所需要的最少代价。
 * 给定两个字符串A和B，及它们的长度和三种操作代价，请返回将A串变为B串所需要的最小代价。
 * 保证两串长度均小于等于300，且三种代价值均小于等于100。
 * 测试样例：
 * "abc",3,"adc",3,5,3,100
 * 返回：8
 * Created by wkhuahuo on 2017/3/1.
 */
public class MinCost {
    /***
     *
     * @param A 字符串A
     * @param n A的长度
     * @param B 字符串B
     * @param m B的长度
     * @param c0 插入
     * @param c1 删除
     * @param c2 修改
     * @return
     */
    public int findMinCost(String A, int n, String B, int m, int c0, int c1, int c2) {
        if (A==null || B == null){
            return 0;
        }
        int aL = A.length();
        int bL = B.length();
        int[][] costs = new int[aL+1][bL+1];
        costs [0][0] = 0;//表示空串
        for(int i=1; i<= aL; i++){//第一列赋初值
            costs[i][0] = costs[i-1][0] + c1;
        }
        for(int i=1; i<= bL; i++){//第一行赋初值
            costs[0][i] = costs[0][i-1] + c0;
        }
        for(int i=1; i<=aL; i++){
            for(int j=1; j<=bL; j++){
                if(A.charAt(i-1) == B.charAt(j-1)){
                    costs[i][j] = costs[i-1][j-1];
                }else{
                    costs[i][j] = costs[i-1][j]+c1;
                    int tmp = costs[i][j-1]+c0;
                    costs[i][j] = costs[i][j]>tmp?tmp:costs[i][j];
                    tmp = costs[i-1][j-1]+c2;
                    costs[i][j] = costs[i][j]>tmp?tmp:costs[i][j];
                }

            }
        }

        return costs[aL][bL];
    }
}
