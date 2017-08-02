package com.algorithm.batAlgorithm.sort.base;

public class MergeSort {
	public int[] mergeSort(int[] A, int n) {
		// write code here
		if(A==null) return A;
		mergeSortCore(A,0,n-1);
		return A;    
	}
	public int[]  mergeSortCore(int[] A, int first, int last){
		
		if(first>last)return A;
		if(first==last) return A ;  
		int mid = (last+first)/2;
		if(first< last){
			mergeSortCore(A,first, mid);
			mergeSortCore(A,mid+1,last);
			merge(A,first,mid,last);
		}
		
		return A;

		
	}
	public  int[] merge(int[] A, int first, int mid, int last){
		if(first==last) return A;
		
		int M[] = new int[last-first+1];
		int iL =first;
		int jR=mid+1;
		int kM =0;
		while(iL<=mid && jR<=last){
			if(A[iL]<=A[jR]){
				M[kM]=A[iL];
				iL++;
				kM++;
			}else {
				M[kM]=A[jR];
				jR++;
				kM++;
			}
		}
		while(iL<=mid){
			M[kM] = A[iL];
			kM++;
			iL++;
		}
		while(jR<=last){
			M[kM] = A[jR];
			kM++;
			jR++;
		}
		kM= 0;
		for(int i=first;i<=last;i++){
			A[i] = M[kM++];
		}
		return A;
	}
}
