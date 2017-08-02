package com.wk.batAlgorithm.sort.practice;

import org.junit.Test;

/**
 * Created by wkhua on 16/11/15.
 */
public class HeapSrotMinTest {
    @Test
    public void testHeapSortMin(){
        int A[] = {7,1,2,4,3,6,5,5};
        for(int i=0;i<A.length;i++){
            System.out.print(A[i]+"," );
        }
        System.out.println();
        HeapSortMin hsm = new HeapSortMin();
        hsm.minheapSort(A, A.length);
        for(int i=0;i<A.length;i++){
            System.out.print(A[i]+"," );
        }

    }
}
