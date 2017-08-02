package com.algorithm.batAlgorithm.sort.practice;

/**
 * Created by wkhuahuo on 10/11/16.
 */
public class SmallScaleSort {

    public int[] sortElement(int[] A, int n, int k) {

        for(int i=((k-1)-1)/2;i>=0;i--){
            adjustHeap(A,i,k-1,0);
        }
        for(int i=0;i<=n-k;i++){
            adjustHeap(A, 0, k-1,i);
        }
    return A;

    }

    private int[] adjustHeap(int[] A, int start, int end,int base){//小根堆调整

        int target = A[start];
        if(start>end){
            return A;
        }
        int rootIndex = start;
        int child = 0;
        int tmp;
        for(;rootIndex*2+1<=end;){
            child = rootIndex*2+1;
            if(child+1<=end){//若果说最后一个节点有右节点
                //寻找较小的孩子
                if(A[child+1]>A[child]){//左较小
                    if(A[child+base] <A[rootIndex+base]){//当前根节点与左孩子节点比较
                        swap(A, child+base, rootIndex+base);
                        rootIndex = child;
                    }else {
                        rootIndex = child;
                    }

                }else {//右孩子比较小
                    if(A[child+1+base] >A[rootIndex+base]){//与右孩子节点比较
                        swap(A, child+base, rootIndex+base);
                        rootIndex = child+1;
                    }else {
                        rootIndex = child;
                    }

                }
            }else if(child<=end){//如果没有只与左孩子节点比较

                if(A[child+base] <A[rootIndex+base]){//如果比较大交换
                    swap(A, child+base, rootIndex+base);
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
