package com.algorithm.baseAlgorithm.run;

/**
 * Created by wkhuahuo on 2017/3/24.
 */
public class MaxHeapSort {
    public void heapSort(int[] arr,int n){
        if(arr == null || arr.length == 0){
            return ;
        }
        for(int i=0;i<n;i++){
            initMaxHeap(arr,n-i);
            swap(arr,0,n-1-i);
        }
        //initMaxHeap(arr,n);
    }
    private void initMaxHeap(int[] arr,int length){
        for(int i=(length-2)/2;i>=0;i--){
            adjust(arr,i,length);
        }
    }
    private void adjust(int [] arr,int index,int length){

        int left = (index<<1)+1;
        int right = (index+1)<<1;
        int maxer = index;

        if(left<length && arr[left]> arr[index]){
            maxer = left;
        }
        if(right<length && arr[right] >arr[maxer]){
            maxer = right;
        }

        if(maxer != index){
            swap(arr,maxer,index);
            adjust(arr,maxer,length);
        }

    }
    private void swap(int[] arr,int a,int b){
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
