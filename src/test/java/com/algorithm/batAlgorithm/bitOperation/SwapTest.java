package com.algorithm.batAlgorithm.bitOperation;

import org.junit.Test;

/**
 * Created by wkhuahuo on 17/02/17.
 */
public class SwapTest {

    @Test
    public void getSwapTest(){
        int[] num = {3,1};
        Swap swap = new Swap();
        num = swap.getSwap(num);
        System.out.println(num[0]+","+num[1]);
    }
}
