package com.algorithm.batAlgorithm.sort.practice;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by wkhua on 16/12/1.
 */
public class SubSequenceTest {

    @Test
    public void shortestSubsequenceTest(){
       // int[] A = {1,4,6,5,9,10};
        int[] A = {1,2,3,3,8,9};
        SubSequence s = new SubSequence();
        int a = s.shortestSubsequence(A,A.length);
        Assert.assertEquals(0,a);
    }
}
