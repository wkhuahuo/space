package com.wk.batAlgorithm.stackAndSequence.practice;

import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;
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
