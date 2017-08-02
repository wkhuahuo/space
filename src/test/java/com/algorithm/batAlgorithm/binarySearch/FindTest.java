package com.algorithm.batAlgorithm.binarySearch;

import org.junit.Test;

/**
 * Created by wkhuahuo on 12/01/17.
 */
public class FindTest {
    @Test
    public void findPosTest(){

        int[] arr ={0,1,5,6,10,13,17,21,22,23,25,27,31,35,38,41};

        Find find = new Find();
        int posi = find.findPos(arr,arr.length);
        System.out.println(posi);
    }
}
