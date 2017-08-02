package com.wk.batAlgorithm.sort.base;

import junit.framework.TestCase;

public class MergeSortTest extends TestCase{
	public void test(){
		int[] A = {54,35,48,36,27,12,44,44,8,14,26,17,28};
//		int[] B = {6,8,9};
//		int[] M =new int[A.length+B.length];
		MergeSort ms = new MergeSort();
		
//		M =ms.merge(A,0,A.length-1);
		
		ms.mergeSort(A, 13);
		
		for(int i:A){
			System.out.print(i+" ");
		}
	}
}
