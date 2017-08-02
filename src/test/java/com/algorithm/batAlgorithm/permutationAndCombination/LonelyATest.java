package com.wk.batAlgorithm.permutationAndCombination;

import org.junit.Test;

/**
 * Created by wkhuahuo on 18/02/17.
 */
public class LonelyATest {
    @Test
    public void getWaysTest(){
        LonelyA a = new LonelyA();
        int num = a.getWays(6,1,2,3);
        System.out.println(num);
    }
}
