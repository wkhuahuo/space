package com.wk.batAlgorithm.bitOperation;

import org.junit.Test;

/**
 * Created by wkhuahuo on 17/02/17.
 */
public class OddsAppearanceTest {

    @Test
    public void findOddsTest(){
        int[] arr = {1,2,3,4,5,7,4,3,2,1};
        OddsAppearance odds = new OddsAppearance();
        int[] result = odds.findOdds(arr,arr.length);
        System.out.println(result[0]+" "+result[1]);
    }
}
