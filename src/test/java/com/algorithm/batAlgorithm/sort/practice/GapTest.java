package com.wk.batAlgorithm.sort.practice;

import org.junit.Test;

/**
 * Created by wkhua on 16/12/1.
 */
public class GapTest {
    @Test
    public void maxGapTest(){

        //int[] A={1,2,5,4,6};
        int[] A={7778,9763,347,8793,4297};
        Gap gap = new Gap();
        int a = gap.maxGap(A,A.length);
     //   Assert.assertEquals(2,a);
        System.out.println(a);
    }

}
