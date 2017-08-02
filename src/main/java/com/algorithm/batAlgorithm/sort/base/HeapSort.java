package com.algorithm.batAlgorithm.sort.base;

public class HeapSort {
	public int[] heapSort(int[] A, int n) {
		if(A==null ||A.length==1){
			return A;
		}
		for(int start = ((n-1)-1)/2; start>=0;start--){//建立大根堆
			 adjustHeap(A, start,A.length-1);
		}
		swap(A, 0 ,n-1);
		for(int i =n-2;i>0;i--){

			adjustHeap(A,0,i);
			swap(A, 0 ,i);
		}



		return A;
    }

    private int[] adjustHeap(int[] A, int start, int end){

		int target = A[start];
		if(start*2>end){
			return A;
		}
		int rootIndex = start;
		int child = 0;
		int tmp;
		for(;rootIndex*2+1<=end;){
			child = rootIndex*2+1;
			if(child+1<=end){//若果说最后一个节点有右节点
				//寻找较大的孩子
				if(A[child+1]<A[child]){//左孩子比较大
					if(A[child] >A[rootIndex]){//当前根节点与左孩子节点比较
						//swap(A, child, rootIndex);
						tmp = A[child];
						A[child] = A[rootIndex];
						A[rootIndex] = tmp;
						rootIndex = child;
					}else {
						rootIndex = child;
					}

				}else {//右孩子比较大
					if(A[child+1] >A[rootIndex]){//与右孩子节点比较
						tmp = A[child+1];
						A[child+1]  = A[rootIndex];
						A[rootIndex] = tmp;
						rootIndex = child+1;
					}else {
						rootIndex = child;
					}

				}
			}else if(child<=end){//如果没有只与左孩子节点比较
				if(A[child] >A[rootIndex]){//如果比较大交换
					tmp = A[child];
					A[child] = A[rootIndex];
					A[rootIndex] = tmp;
					rootIndex = child;
				}else {
					rootIndex = child;
				}
			}
		}
		return A;
	}
	private void swap(int[] A, int a, int b){
		int tmp;
		tmp =A[a];
		A[a] = A[b];
		A[b] = tmp;
	}
}
