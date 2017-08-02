package com.algorithm.lintCode.run;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangkai43 on 2017/7/27.
 */
public class Median_of_two_Sorted_Arrays {
    /**
     * @param A: An integer array.
     * @param B: An integer array.
     * @return: a double whose format is *.5 or *.0
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        // write your code here

        List<Integer> combine = new ArrayList<Integer>();
        int indexA = 0;
        int indexB = 0;


        while(indexA<A.length && indexB<B.length){
            if(A[indexA]>B[indexB]){
                combine.add(B[indexB++]);
            }else {
                combine.add(A[indexA++]);

            }
        }

        while(indexA<A.length){
            combine.add( A[indexA++]);
        }

        while(indexB<B.length){
            combine.add( B[indexB++]);
        }

        double result = 0.0;

        if(combine.size() == 1){
            result = combine.get(0);
        }else{

            if(combine.size()%2 == 1){

                result = combine.get(combine.size()/2);
            }else{
                int mid = (combine.size()/2);
                result = (combine.get(mid -1)+combine.get(mid))/2.0;
            }
        }
        return result;
    }
}
