package com.algorithm.swordoffer.test;

import com.algorithm.swordoffer.run.ReplaceWork;

import junit.framework.TestCase;

public class ReplaceWorkTest extends TestCase{
	public void test(){
		
		StringBuffer strB = new StringBuffer("we are family");
		ReplaceWork rw = new ReplaceWork();
		System.out.println(rw.replaceSpace(strB));
	}
	public void _testStringBuffer(){
		StringBuffer strB = new StringBuffer("haha");
		strB.append('H'); 
		System.out.println(strB.toString());
		System.out.println(strB.charAt(4));
		assertEquals('H', strB.charAt(4));
	
	}
}
