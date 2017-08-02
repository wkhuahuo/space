package com.algorithm.batAlgorithm.stackAndSequence.practice;

import org.junit.Test;

/**
 * Created by wkhua on 16/12/15.
 */
public class MaxTreeTest {
    @Test
    public void buildMaxTreeTest(){
        //   int[] A = {3,1,4,2};
        //        int[] A = {36,1173,934,436};//[1,-1,1,2]
              int[] A = {340,1387,2101,847,1660,733,36,528};
        MaxTree maxTree = new MaxTree();
  //      int[] result = maxTree.buildMaxTreeDemo(A,A.length);
        int[] result = maxTree.buildMaxTree(A,A.length);
        for(int i:result){
            System.out.print(i+" ");
        }
    }
}
