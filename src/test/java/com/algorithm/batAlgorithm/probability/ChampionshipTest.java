package com.algorithm.batAlgorithm.probability;

import org.junit.Test;

/**
 * Created by wkhuahuo on 19/02/17.
 */
public class ChampionshipTest {
    @Test
    public void caclTest(){
        Championship chp = new Championship();
        int[] m=chp.calc(4);
        System.out.println(m[0]+","+m[1]);
    }
}
