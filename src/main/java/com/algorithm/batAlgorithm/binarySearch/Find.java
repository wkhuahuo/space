package com.algorithm.batAlgorithm.binarySearch;

/**
 *

 有一个有序数组arr，其中不含有重复元素，请找到满足arr[i]==i条件的最左的位置。如果所有位置上的数都不满足条件，返回-1。

 给定有序数组arr及它的大小n，请返回所求值。
 测试样例：

 [-1,0,2,3],4

 返回：2


 * Created by wkhuahuo on 12/01/17.
 */
public class Find {
    public int findPos(int[] arr, int n) {
        // write code here
        if(arr ==null || arr.length==0 ||arr[0]>arr.length-1 || arr[arr.length-1]<0){
            return -1;
        }
        int left =0;
        int right =arr.length-1;
        int mid = left + (right-left)/2;

        while(left<right){


            if(arr[mid]<mid){
                left = mid+1;
            }else if(arr[mid]>=mid){
                right = mid;
            }

            mid =  left + (right-left)/2;
        }

        return mid;
    }
}
