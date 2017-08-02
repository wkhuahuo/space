package com.algorithm.batAlgorithm.linkedlist;

import org.junit.Test;

/**
 * Created by wkhuahuo on 09/01/17.
 */
public class RandomListNdoeCopyTest {

    @Test
    public void Clonetest(){
        int[] arr = {1,2,3,4,5};
        int[] random = {2,3,0,4,-1};
        RandomListNode randomNode = MyUtil.initRandomListNode(arr,random);
        RandomListNodeCopy rCopy = new RandomListNodeCopy();

        System.out.println("before: "+MyUtil.myString(randomNode));
        RandomListNode CopyedRandomNode = rCopy.Clone(randomNode);
        System.out.println("Copyed: "+MyUtil.myString(CopyedRandomNode));

    }

}
