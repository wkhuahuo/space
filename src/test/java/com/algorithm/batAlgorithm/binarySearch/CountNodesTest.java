package com.algorithm.batAlgorithm.binarySearch;

import org.junit.Test;

/**
 * Created by wkhuahuo on 12/01/17.
 */
public class CountNodesTest {

    @Test
    public void countTest(){

        int[] arr = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};

        TreeNode root = MyUtil.initCompleteBinaryTree(arr);


        String treeStr = MyUtil.myString(root);
        System.out.println(">>=>>"+treeStr);
        CountNodes countN = new CountNodes();
        int num = countN.count(root);
        System.out.println(num);
    }
}
