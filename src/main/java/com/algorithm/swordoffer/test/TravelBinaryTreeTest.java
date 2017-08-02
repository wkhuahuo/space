package com.algorithm.swordoffer.test;

import com.algorithm.swordoffer.run.TravelBinaryTree;

import junit.framework.TestCase;

public class TravelBinaryTreeTest extends TestCase{
	public void test(){
		int[] testarr = {5,7,6,9,11,10,8};
		
		TravelBinaryTree tbt = new TravelBinaryTree();
		boolean result = tbt.VerifySquenceOfBST(testarr);
		System.out.println(result);
		assertTrue(result);
	}
}
