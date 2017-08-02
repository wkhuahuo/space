package com.algorithm.batAlgorithm.sort.base;

public class ShellSort {
	public int[] shellSort(int[] A, int n) {
		int step = n/2;
		while (step>0) {
			for (int i = 0; i <step; i++) {
				for (int j = i + step; j < n; j += step) {
					for(int k = j-step;k>=i;k-=step){
						if(compare(A,k,k+step)){
							swap(A,k,k+step);
						}else{
							break;
						}
					}

				}
			}
			step/=2;
		}
		return A;
	}

	private void swap(int[] a, int k, int i) {
		int tmp;
		tmp = a[k];
		a[k] = a[i];
		a[i] = tmp;
	}

	private boolean compare(int[] a, int k, int i) {
		if(a[k]>a[i]) {
			return true;//a[k]>a[i]
		}else {
			return false;
		}
	}
}
