package com.algorithm.batAlgorithm.binarySearch;

/**
 * Created by wkhuahuo on 12/01/17.
 */
public class MinValue {
    public int getMin(int[] arr, int n) {
        if(arr ==null || arr.length ==0){
            return -1;
        }
        int left = 0;
        int right = arr.length-1;
        int mid = left+(right-left)/2;
        while(left<right){
            if(arr[left]<arr[right]){
                return arr[left];
            }
            if(arr[left] == arr[mid]){
                left = left+(mid-left)/2;
            }
            if(arr[right] == arr[mid]){
                right = mid+(right-mid)/2;
            }
            if(arr[left]>arr[mid]){
                right = mid;
            }else if(arr[right]<arr[mid]){
                left = mid+1;
            }
            mid = left+(right-left)/2;
        }

        return arr[mid];
    }
}
