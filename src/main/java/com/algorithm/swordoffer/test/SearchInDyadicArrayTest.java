package com.algorithm.swordoffer.test;

import com.algorithm.swordoffer.run.SearchInDyadicArray;

import junit.framework.TestCase;

public class SearchInDyadicArrayTest extends TestCase{
	public void test(){
		int [] [] array ={ {1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}}; 
		int target = 17;
		SearchInDyadicArray sia = new SearchInDyadicArray();
		boolean tOrF = sia.Find(array, target);
		//assertTrue(tOrF);
		assertFalse(tOrF);
	}
}
