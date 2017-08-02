package com.algorithm.batAlgorithm.dynamicprogramming;

import org.junit.Test;

/**
 * Created by wkhuahuo on 2017/2/28.
 */
public class GoUpstairsTest {
    @Test
    public void countWays(){
        GoUpstairs go = new GoUpstairs();
        int i = go.countWays(3);
        System.out.print(i);

    }
}
