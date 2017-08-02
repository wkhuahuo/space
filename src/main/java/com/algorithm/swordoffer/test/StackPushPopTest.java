package com.algorithm.swordoffer.test;

import com.algorithm.swordoffer.run.StackPushPop;

import junit.framework.TestCase;

public class StackPushPopTest extends TestCase{
	public void test(){
		
		int [] pushA ={1,2,3,4,5};
		int [] popA = {4,5,3,2,1};
//		int [] popA = {4,3,5,1,2};
		StackPushPop spp = new StackPushPop();
		boolean result =spp.IsPopOrder(pushA, popA);
//		assertFalse("false",result);
		assertTrue("true",result);
	}
}
