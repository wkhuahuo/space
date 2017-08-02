package com.wk.batAlgorithm.bitOperation;

import org.junit.Test;

/**
 * Created by wkhuahuo on 17/02/17.
 */
public class CompareTest {

    @Test
    public void getMaxTest(){
        Compare c = new Compare();
        int max = c.getMax(23,3);
        System.out.println(max);
    }
}
