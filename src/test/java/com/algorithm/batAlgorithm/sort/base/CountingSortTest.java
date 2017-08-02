package com.algorithm.batAlgorithm.sort.base;

import junit.framework.TestCase;

/**
 * Created by wkhuahuo on 16/10/6.
 */
public class CountingSortTest extends TestCase{
    public void test(){
        int[] A = {54,35,48,36,27,12,44,44,8,14,26,17,28};
        CountingSort cs = new CountingSort();
        cs.countingSort(A,A.length);
        for(int i : A){
            System.out.print(i+" ");
        }
    }
}
