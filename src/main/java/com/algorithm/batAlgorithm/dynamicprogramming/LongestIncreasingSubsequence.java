package com.algorithm.batAlgorithm.dynamicprogramming;

/**
 * 经典的LIS（最长上升子序列）问题，设计一个解法求得最长上升子序列长度
 * 给定一个序列A及长度n（n<=500)，请返回LIS的长度。
 * 用例：
 * [1,4,2,5,3],5
 * 返回：3
 * Created by wkhuahuo on 2017/2/28.
 */
public class LongestIncreasingSubsequence {
    public int getLIS(int[] A, int n) {
        if(A==null || A.length ==0){
            return 0;
        }
        int[] lens = new int[A.length];
        lens[0] = 1;
        int max = 1;
        for(int i=1;i<A.length;i++){
            lens[i] = getmax(A,lens,i)+1;
            if(lens[i]>max){
                max = lens[i];
            }
        }
        return max;
    }

    private int getmax(int[] A,int[] lens,int index){
        int maxindex = 0;
        for(int j = index-1;j>=0;j--){
            if(A[index]>A[j]){
                if(lens[j]>maxindex){
                    maxindex = lens[j];

                }
            }
        }
        return maxindex;
    }
}
