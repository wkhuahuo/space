package com.algorithm.baseAlgorithm.run;

/**
 * Created by wkhuahuo on 2017/3/24.
 */
public class MinHeapSort {
    public void heapSort(int[] arr,int n){
       for(int i=0;i<arr.length;i++){
            initMinHeap(arr, n-i);
            swap(arr,0,n-1-i);
        }
    //  initMinHeap(arr,n);


    }

    /***
     * 建立小根堆，应该找到最后一个根节点，从该节点开始建立小根堆
     * @param arr 待建立的数组
     * @param length 该数组的长度
     */
    private void initMinHeap(int[] arr, int length){
        //从最后一个根节点开始建立最小堆
        for(int i=(length-2)/2;i>=0;i--){
            adjust(arr,i,length);//传入根节点位置
        }
    }

    /***
     * 调整小根堆，
     * @param arr 小根堆数组
     * @param index 当前节点所在位置
     * @param length 当前小根堆数组长度
     */
    private void adjust(int[] arr,int index,int length){

        int left = (index<<1)+1;//2*index+1;//2*i+1
        int right = (index+1)<<1;//2*index+2;//2*i+2
        int smaller = index;//

        if(left<length && arr[left]<arr[index]){
            smaller = left;
        }
        if(right<length && arr[right] <arr[smaller]){
            smaller = right;
        }

        if(index != smaller){
            swap(arr,index,smaller);
            adjust(arr,smaller,length);//如果根节点被改变那么应该引起向下层的调整
        }

    }

    private void swap(int[] arr,int a,int b){
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

}
