package com.algorithm.batAlgorithm.binarySearch;

import org.junit.Test;

/**
 * Created by wkhuahuo on 12/01/17.
 */
public class MinValueTest {
    @Test
    public void getMinTest(){
        int[] arr1 = {4,5,6,7,8,9,0,1,2,3};
        int[] arr = {3,3,3,3,3,3,0,3,3,3};
        MinValue min = new MinValue();
        int  minv = min.getMin(arr,arr.length);
        System.out.println(minv);
    }
}
