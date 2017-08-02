package com.algorithm.batAlgorithm.sort.practice;

import com.algorithm.batAlgorithm.sort.base.ShellSort;

/**
 * Created by wkhua on 16/11/30.
 */
public class ThreeColor {
    public int[] sortThreeColor(int[] A, int n) {
        // write code here

       ShellSort shellsort = new ShellSort();
        shellsort.shellSort(A,n);

        return A;
    }

    public int[] sortThreeColorofBest(int[] A, int n){
        int left= -1;
        int index =0;
        int right =n;
       while(index<right){
           if(A[index]==0){
               left++;
               swap(left,index,A);
               index++;
           }else if(A[index] == 2){
               right--;
               swap(right,index,A);

           }else{
               index++;
           }



       }
       return A;
    }

    private void swap(int left, int right, int[] a) {
        if(left<0||right<0){
            return;
        }
        int tmp = a[left];
        a[left] = a[right];
        a[right] = tmp;
    }


}
