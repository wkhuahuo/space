package com.algorithm.swordoffer.test;

import com.algorithm.swordoffer.run.RectangleOfN;

import junit.framework.TestCase;

public class RectangleOfNTest extends TestCase{
	public void test(){
		int num = 4;
		int result = 0;
		RectangleOfN recn = new RectangleOfN();
		result = recn.RectCover(num);
		System.out.println(result);
	}
}
