package com.algorithm.swordoffer.test;

import com.algorithm.swordoffer.run.Chapter2.NumberOfOneInBinary;

import junit.framework.TestCase;

public class NumberOfOneInBinaryTest extends TestCase{
	public void test(){
		int result =0;
		NumberOfOneInBinary numOf1 = new NumberOfOneInBinary();
		result = numOf1.numberOf1(9);
		System.out.println("hello "+result);
	//	assertEquals("Equal",1,result);
	}
	
	
	public void __test_binary(){
		assertEquals("Equal",6,2|4);
		assertEquals("Equal",2,2&6);
		assertEquals("Equal",2,1<<1);
	}

}
