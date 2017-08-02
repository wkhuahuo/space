package com.algorithm.batAlgorithm.sort.base;

public class QuickSort {
	
	public int[] quickSort(int[] A, int n) {
	    // write code here
		sort(A,0,n-1);
		return A; 
	}
	public int[] sort(int[] A, int left, int right){
		
		if(left<0||right<0||left>=right){
			return A;
		}
 		int i= left;
		int j= right;
		int tmp=0;
		boolean flag = true;
		while(i<j){
			if(A[i]>A[left]){
				tmp=A[i];
				A[i] =A[j];
				A[j] =tmp;
				flag =true;
			}else if(A[j]<A[left]){
				flag =false;
			}
			if(flag){
				j--;
			}else {
				i++;
			}
		}
		
			tmp=A[i];
			A[i] =A[left];
			A[left] =tmp;
			sort(A,left,i-1);
			sort(A,i+1,right);
		
		return A;
	}
}
	