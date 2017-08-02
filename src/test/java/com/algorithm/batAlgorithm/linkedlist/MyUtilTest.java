package com.algorithm.batAlgorithm.linkedlist;

import org.junit.Test;

/**
 * Created by wkhuahuo on 09/01/17.
 */
public class MyUtilTest {
    @Test
    public void initRandomListNodeTest(){
        int[] arr = {1,1,2,2,3,3,4,4,5,5};
        int[] random = {4,5,6,7,0,1,8,9,-1,-1};
        RandomListNode randomNode = MyUtil.initRandomListNode(arr,random);
        System.out.print(MyUtil.myString(randomNode));
    }

}
