package com.algorithm.batAlgorithm.sort.practice;

/**
 * Created by wkhua on 16/12/1.
 */
public class SubSequence {

    public int shortestSubsequence(int[] A, int n) {
        if(A==null||A.length==0){
            return 0;
        }

        int flagLeft = 1;
        int flagRight = 0;
        int max = A[0];
        int min = A[A.length-1];
        for(int i=1;i<n;i++){
            if(A[i]>=max){
                max = A[i];
            }else{
                flagRight = i;
            }
        }
        for(int i=n-1;i>=0;i--){
            if(A[i]<=min){
                min = A[i];
            }else{
                flagLeft = i;
            }
        }
        return flagRight-flagLeft+1;
    }
}
