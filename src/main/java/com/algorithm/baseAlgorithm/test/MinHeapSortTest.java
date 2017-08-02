package com.algorithm.baseAlgorithm.test;

import com.algorithm.baseAlgorithm.run.MinHeapSort;

import java.util.Arrays;

/**
 * Created by wkhuahuo on 2017/3/24.
 */
public class MinHeapSortTest {
    public static void main(String[] args){
        MinHeapSort minh = new MinHeapSort();
        int[] arr = {9,6,3,11,8,7,2,5,10,4,1};
        minh.heapSort(arr,arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
