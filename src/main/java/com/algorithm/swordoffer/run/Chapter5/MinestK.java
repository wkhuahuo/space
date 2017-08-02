package com.algorithm.swordoffer.run.Chapter5;

import java.util.ArrayList;

/**
 * Created by wkhuahuo on 2017/3/24.
 */
public class MinestK {
    //使用大根堆解法
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if(input == null){
            return null;
        }
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        if(k>input.length || k<=0) {
            return arrayList;
        }

        int[] heap = new int[k];
        for(int i=0; i<k;i++){
            heap[i] = input[i];
        }
        maxHeapofk(heap,k);
        for(int i=k;i<input.length;i++){
            if(input[i] < heap[0]){
                heap[0] = input[i];
                maxHeapofk(heap,k);
            }
        }
        swap(heap,0,k-1);
        for(int i=1;i<heap.length;i++){

            maxHeapofk(heap,k-i);
            swap(heap,0,k-1-i);
        }

        for(int i: heap) {
            arrayList.add(i);
        }
        return arrayList;
    }

    private void maxHeapofk(int[] heap, int length){

        for(int i = (length-2)/2; i>=0;i--){
            adjust(heap,i,length);
        }

    }

    private void adjust(int[] heap, int index,int length){


        int left = (index<<1)+1;
        int right = (index+1)<<1;
        int maxer = index;

        if(left < length && heap[left] > heap[index]){
            maxer = left;
        }
        if(right < length && heap[right] > heap[maxer]){
            maxer = right;
        }

        if(maxer !=index) {
            swap(heap,maxer,index);
            adjust(heap, maxer, length);
        }
    }

    private void swap(int[] heap, int a, int b){
        int tmp = heap[a];
        heap[a] = heap[b];
        heap[b] = tmp;
    }
}
