package com.algorithm.batAlgorithm.sort.practice;

import junit.framework.TestCase;

/**
 * Created by wkhuahuo on 10/11/16.
 */
public class SmallScaleSortTest extends TestCase{
    public void test(){
        int[] A = {2,1,4,3,6,5,8,7,10,9};
        int k = 5;
        SmallScaleSort sss = new SmallScaleSort();

        sss.sortElement(A,A.length,k);
        for(int a:A){
            System.out.print(a+" ");
        }
    }

}
