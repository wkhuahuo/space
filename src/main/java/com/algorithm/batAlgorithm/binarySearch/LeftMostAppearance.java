package com.algorithm.batAlgorithm.binarySearch;

/**
 * Created by wkhuahuo on 11/01/17.
 */
public class LeftMostAppearance {
    public int findPos(int[] arr, int n, int num) {
        // write code here
        if(arr ==null ||arr.length ==0){
            return -1;
        }
        int left =0;
        int right = arr.length-1;
        int mid = left +(right-left)/2;

        while(left<right){
            if(arr[mid] == num){
                if(mid>0 && arr[mid-1]==arr[mid]) {
                    right = mid;
                }else {
                    return mid;
                }
            }else if(arr[mid] < num){
                left = mid+1;
            }else{
                right = mid;
            }
            mid = left +(right-left)/2;
        }

        if(arr[mid] == num){
            return mid;
        }
        return -1;
    }
}
