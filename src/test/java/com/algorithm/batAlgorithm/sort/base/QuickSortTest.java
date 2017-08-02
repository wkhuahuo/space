package com.algorithm.batAlgorithm.sort.base;

import junit.framework.TestCase;

public class QuickSortTest extends TestCase{
	public void test(){
		int A[] = {54,35,48,36,27,12,44,44,8,14,26,17,28};
		int B[] = {6,1,2,7,9,3,4,5,10,8};
		QuickSort qs = new QuickSort();
		qs.quickSort(A,A.length);
	//	qs.quickSort(B,B.length);
		for(int i: A){
			System.out.print(i+" ");
		}
	}

}
