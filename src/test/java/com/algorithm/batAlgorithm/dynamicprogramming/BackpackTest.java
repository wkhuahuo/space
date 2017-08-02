package com.wk.batAlgorithm.dynamicprogramming;

import org.junit.Test;

/**
 * Created by wkhuahuo on 2017/3/1.
 */
public class BackpackTest {
    @Test
    public void maxValue(){
        int[] w = {16,36,25,19,26,23};
        int [] v = {619,363,582,163,487,344};
        int cap =35;
        Backpack backpack = new Backpack();
        int result =backpack.maxValue(w,v,w.length,cap);
        System.out.print(result);
    }
}
