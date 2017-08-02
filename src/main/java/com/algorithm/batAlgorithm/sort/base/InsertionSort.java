package com.algorithm.batAlgorithm.sort.base;

public class InsertionSort {
	public int[] insertionSort(int[] A, int n) {
		if(A==null||n<2)return A;
		
		int posi=0;
		int pre = 0;
		int tmp =0;
		for(int i=1;i<n;i++){
			posi = i;
			pre = i-1;
			while(pre>=0 && A[posi]<A[pre]){
				tmp = A[posi]; 
				A[posi] = A[pre];
				A[pre] = tmp;
				posi = pre;
				pre--;
			}
		}
		return A;
	}
}
