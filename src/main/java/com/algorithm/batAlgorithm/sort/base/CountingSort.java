package com.algorithm.batAlgorithm.sort.base;

/**
 * Created by wkhuahuo on 16/10/6.
 */
public class CountingSort {
    public int[] countingSort(int[] A, int n) {
        // write code here
        if(A == null || A.length<2) return A;
        int max = A[0];
        int min = A[0];

        for(int i =0; i<A.length; i++){
            if(A[i]>max){
                max = A[i];
            }
            if(A[i]<min){
                min = A[i];
            }
        }//获取最大值和最小值//
        int arr[] = new int[max-min+1];//开辟数组
        for(int i=0; i<arr.length; i++){//初始化
            arr[i] = 0;
        }
        for(int i=0; i<A.length; i++){//把A的值映射到arr
            arr[A[i] - min]++;//如果有x个相同的数，则值为x
        }
        int count = 0;
        for(int i=0; i<arr.length; i++){//遍历数组
            while(arr[i]>0){
                A[count] = i+min;
                count++;
                arr[i]--;

            }
            if(count==A.length){
                break;
            }
        }
        return A;
    }
}
