package com.algorithm.batAlgorithm.sort.base;

public class SelectionSort {
	 public int[] selectionSort(int[] A, int n) {
	        // write code here
		int posi = 0;
        int min=A[posi];
        while(posi<n){
	        for( int i=posi+1;i<n;i++){
	            if(A[i]< A[posi]){
	            	int tmp = A[i];
	            	A[i] = A[posi];
	            	A[posi] = tmp;
	            }
	        }
	        posi++;
        }
		return A;
		
    }
}
