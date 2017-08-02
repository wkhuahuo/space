package com.wk.batAlgorithm.dynamicprogramming;

import org.junit.Test;

/**
 * Created by wkhuahuo on 2017/2/28.
 */
public class MinimumPathTest {
    @Test
    public void getMin(){
        MinimumPath min = new MinimumPath();
        int[][] map = {{1,2,3},{1,1,1}};
        int m = min.getMin(map, 2,3);
        System.out.println(m);
    }
}
