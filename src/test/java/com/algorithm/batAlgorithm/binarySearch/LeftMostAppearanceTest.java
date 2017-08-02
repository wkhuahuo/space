package com.algorithm.batAlgorithm.binarySearch;

import org.junit.Test;

/**
 * Created by wkhuahuo on 11/01/17.
 */
public class LeftMostAppearanceTest {
    @Test
    public void findPosTest(){
        int[] arr = {2,3,3,3,4,5,6,7,7,7,7,13};

        LeftMostAppearance left = new LeftMostAppearance();
        int pos = left.findPos(arr,arr.length,14);
        System.out.println(pos);
    }
}
