package com.algorithm.swordoffer.test;

import com.algorithm.swordoffer.run.SpinArray;

import junit.framework.TestCase;

public class SpinArrayTest extends TestCase{
	
	public void tearUp(){
		
		
	}
	
	
	public void testminNumberInRotateArray(){
		SpinArray sa = new SpinArray();
		int[] array = {1,0,1,1,1};
		int result=0;
		result = sa.minNumberInRotateArray(array);
		
		assertEquals("等于", 0,result);
		System.out.println(result);
	}
	
	
}
