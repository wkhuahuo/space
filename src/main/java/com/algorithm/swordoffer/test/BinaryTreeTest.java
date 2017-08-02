package com.algorithm.swordoffer.test;

import com.algorithm.swordoffer.run.BinaryTree;

import junit.framework.TestCase;

public class BinaryTreeTest extends TestCase{
	public void test(){
		int[] pre = {1,2,4,7,3,5,6,8};
		int[] in ={4,7,2,1,5,3,8,6};
		BinaryTree bt = new BinaryTree();
		bt.reConstructBinaryTree(pre, in);
		
	}
}
