package com.algorithm.batAlgorithm.stackAndSequence.practice;

import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by wkhua on 16/12/15.
 */
public class TwoStackSortTest {
    @Test
    public void twoStacksSortTest(){
        int[] numbers = {3,4,5,1,2};
        TwoStackSort tss = new TwoStackSort();
        ArrayList<Integer> arrayList= tss.twoStacksSort(numbers);
        System.out.println(arrayList.toString());
    }
}
