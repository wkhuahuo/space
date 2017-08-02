package com.wk.batAlgorithm.permutationAndCombination;

import org.junit.Test;

/**
 * Created by wkhuahuo on 18/02/17.
 */
public class DistributionTest {
    @Test
    public void getWaysTest(){
        Distribution distri = new Distribution();
        int num = distri.getWays(5,3);
        System.out.println(num);
    }
}
