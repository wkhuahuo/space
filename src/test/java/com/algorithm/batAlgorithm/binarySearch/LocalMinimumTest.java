package com.wk.batAlgorithm.binarySearch;

import org.junit.Test;

/**
 * Created by wkhuahuo on 11/01/17.
 */
public class LocalMinimumTest {

    @Test
    public void getLessIndexTest(){
        int[] arr = {1,2,4,3,7,9,8,2,1};
        int[] arr2 = {3,2,1,2,4};
        int[] arr3 = {4,3,4,7,1,3,5};
        LocalMinimum localMin = new LocalMinimum();
        int result = localMin.getLessIndex(arr3);

        System.out.print("result: "+result);

    }
}
