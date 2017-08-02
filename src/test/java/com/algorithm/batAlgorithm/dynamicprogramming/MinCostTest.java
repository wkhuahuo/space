package com.algorithm.batAlgorithm.dynamicprogramming;

import org.junit.Test;

/**
 * Created by wkhuahuo on 2017/3/1.
 */
public class MinCostTest {
    @Test
    public void findMinCost(){
        String A = "ab12cd3";
        String B = "abcdf";
        int ic0 = 5;
        int dc1 = 3;
        int rc2 = 2;
        MinCost minCost = new MinCost();
        int result = minCost.findMinCost(A,A.length(),B,B.length(),ic0,dc1,rc2);
        System.out.println(result);
    }

}
