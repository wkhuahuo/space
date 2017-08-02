package com.algorithm.baseAlgorithm.test;

import com.algorithm.baseAlgorithm.run.MaxHeapSort;

import java.util.Arrays;

/**
 * Created by wkhuahuo on 2017/3/24.
 */
public class MaxHeapSortTest {
    public static void main(String[] args){
        int[] arr = {9,6,3,11,8,7,2,5,10,4,1};
        MaxHeapSort maxh = new MaxHeapSort();
        maxh.heapSort(arr,arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
