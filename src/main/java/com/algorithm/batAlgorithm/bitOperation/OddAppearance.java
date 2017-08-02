package com.algorithm.batAlgorithm.bitOperation;

/**
 * Created by wkhuahuo on 17/02/17.
 */
public class OddAppearance {
    public int findOdd(int[] A, int n) {
        int num = A[0];
        for(int i=1;i<A.length;i++){
            num ^=A[i];
        }
        return num;
    }


}
