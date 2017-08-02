package com.algorithm.batAlgorithm.sort.practice;

/**
 * Created by wkhua on 16/12/1.
 */
public class ArrayFind {

    public boolean findX(int[][] mat, int n, int m, int x) {

        int tmpRow =n-1;
        int tmpColumn =0;
        while(tmpColumn<m && tmpRow>=0){
            if(mat[tmpRow][tmpColumn]<x){
                tmpColumn++;
            }else if(mat[tmpRow][tmpColumn]>x){
                tmpRow--;
            }else{
                return true;
            }
        }
        return false;

    }
}
