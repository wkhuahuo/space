package com.algorithm.batAlgorithm.sort.practice;

/**
 * Created by wkhua on 16/12/1.
 */
public class Gap {
    public int maxGap(int[] A, int n) {
        int max =Integer.MIN_VALUE;
        int min =Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(A[i] >max){
                max =A[i];
            }
            if(A[i] <= min){
                min =A[i];
            }
        }
        int[] arr =new int[max-min+1];
        for(int i=0;i<arr.length;i++){
            arr[i] = -1;
        }
        for(int i=0;i<n;i++){
            arr[A[i]-min] = i;
        }
        int gap=0;
        int count =0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] == -1){
                count++;
            }else{
                gap = count>gap? count:gap;
                count = 0;
            }
        }

        return gap+1;
    }
}
