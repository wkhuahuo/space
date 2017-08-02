package com.algorithm.batAlgorithm.permutationAndCombination;

import org.junit.Test;

/**
 * Created by wkhuahuo on 18/02/17.
 */
public class CombineByMistakeTest {

    @Test
    public void getWaysTest(){
        CombineByMistake cbm = new CombineByMistake();
        int m = cbm.countWays(7);
        System.out.println(m);
    }

}
