package com.algorithm.batAlgorithm.sort.base;

import junit.framework.TestCase;

public class HeapSortTest extends TestCase{
	public void test(){
		int[] A = {54,35,48,36,27,12,44,44,8,14,26,17,28};
		HeapSort hs = new HeapSort();
		hs.heapSort(A, A.length);
		
		for(int i:A){
			System.out.print(i+" ");
		}
	}
}
