package com.algorithm.swordoffer.test;

import com.algorithm.swordoffer.run.Power;

import junit.framework.TestCase;

public class PowerTest extends TestCase{
	public void test(){
		double result = 0;
		double expect = 0;
		
		Power power = new Power();
		result = power.power(0, -2);
		
		assertEquals("true",expect,result);
	}
	public void test2(){
		double result = 0.0;
		assertEquals("equal",0.0000000001,result);
	}
}
