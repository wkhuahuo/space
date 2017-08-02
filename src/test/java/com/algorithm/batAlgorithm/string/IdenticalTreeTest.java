package com.algorithm.batAlgorithm.string;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by wkhua on 16/12/3.
 */
public class IdenticalTreeTest {
    TreeNode treeNodeA= null;
    TreeNode treeNodeB= null;
    @Before
    public void before(){
        treeNodeA = new TreeNode(1);
        treeNodeA.left = new TreeNode(1);
        treeNodeA.right = new TreeNode(1);


        TreeNode tmpNode = treeNodeA.left;
        tmpNode.right = new TreeNode(1);

        tmpNode = treeNodeA.right;
        tmpNode.left = new TreeNode(1);



        treeNodeB = new TreeNode(1);
        tmpNode = treeNodeB;
        tmpNode.left = new TreeNode(1);
        tmpNode.right = new TreeNode(1);

    }

    @Test
    public void identicalTree1(){
        IdenticalTree iT = new IdenticalTree();
        boolean isTrue = iT.chkIdentical(treeNodeA,treeNodeB);

        Assert.assertFalse(isTrue);
    }

    @Test
    public void mahao(){
        boolean isTrue = IdenticalTree.isSubTree(treeNodeA,treeNodeB);
        Assert.assertFalse(isTrue);
    }
}
