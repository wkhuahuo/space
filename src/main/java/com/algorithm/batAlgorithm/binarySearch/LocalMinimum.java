package com.algorithm.batAlgorithm.binarySearch;

/**
 * 定义局部最小的概念。arr长度为1时，arr[0]是局部最小。arr的长度为N(N>1)时，如果arr[0]<arr[1]，那么arr[0]是局部最小；如果arr[N-1]<arr[N-2]，那么arr[N-1]是局部最小；如果0<i<N-1，既有arr[i]<arr[i-1]又有arr[i]<arr[i+1]，那么arr[i]是局部最小。 给定无序数组arr，已知arr中任意两个相邻的数都不相等，写一个函数，只需返回arr中任意一个局部最小出现的位置即可。
 *
 * Created by wkhuahuo on 11/01/17.
 */
public class LocalMinimum {
    //二分搜索法
    public int getLessIndex(int[] arr) {
        if(arr == null ||arr.length==0){
            return -1;
        }
        if(arr.length ==1){
            return 0;
        }
        if(arr.length == 2){
            if(arr[0]<arr[1]){
                return 0;
            }else{
                return 1;
            }
        }
        int left =0;
        int right = arr.length-1;
        int mid =0;
        while(left < right){
            mid =left + (right-left)/2;
            if(arr[left]<arr[left+1]){
                return left;
            }
            if(arr[right]<arr[right-1]){
                return right;
            }
            if(arr[mid]<arr[mid+1] && arr[mid]< arr[mid-1]){
                return mid;
            }

            if(arr[mid]>arr[mid+1]){
                left = mid;
            }else if(arr[mid]>arr[mid-1]){
                right = mid;
            }

        }
        return -1;
    }
    //普通解法
    public int getLessIndex2(int[] arr) {
        if(arr.length==0){
            return -1;
        }
        if(arr.length ==1){
            return 0;
        }
        if(arr.length == 2){
            if(arr[0]<arr[1]){
                return 0;
            }else{
                return 1;
            }
        }
        for(int i=1;i<arr.length-1;i++){
            if(arr[i]<arr[i-1] && arr[i]<arr[i+1]){
                return i;
            }
        }

        if(arr[arr.length-1]<arr[arr.length-2]){
            return arr.length-1;
        }

        return -1;
    }
}
