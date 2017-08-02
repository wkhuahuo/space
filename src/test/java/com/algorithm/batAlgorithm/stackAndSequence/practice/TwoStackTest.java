package com.algorithm.batAlgorithm.stackAndSequence.practice;

import org.junit.Test;

/**
 * Created by wkhua on 16/12/14.
 */
public class TwoStackTest {
    @Test
    public void twoStackTest(){
        int[] ope = {1,2,3,4,0};
        TwoStack ts = new TwoStack();
        int[] arr = ts.twoStack(ope,ope.length);
        for(int i: arr) {
            System.out.print(i+" ");
        }
    }
}
