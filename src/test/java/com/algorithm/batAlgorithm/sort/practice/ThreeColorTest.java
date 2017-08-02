package com.wk.batAlgorithm.sort.practice;

import org.junit.Test;

/**
 * Created by wkhua on 16/11/30.
 */
public class ThreeColorTest {
    @Test
    public void testThreeColor1(){
        int[] A ={0,1,1,2,1,0};
        ThreeColor threeColor = new ThreeColor();

        for(int i = 0;i<A.length;i++) {
            System.out.print(A[i]+" ");
        }
        System.out.println();
        A = threeColor.sortThreeColor(A,A.length);
        for(int i = 0;i<A.length;i++) {
            System.out.print(A[i]+" ");
        }
    }
    @Test
    public void testThreeColor2(){
        int[] A ={0,1,1,2,1,0};
        ThreeColor threeColor = new ThreeColor();

        for(int i = 0;i<A.length;i++) {
            System.out.print(A[i]+" ");
        }
        System.out.println();
        A = threeColor.sortThreeColorofBest(A,A.length);
        for(int i = 0;i<A.length;i++) {
            System.out.print(A[i]+" ");
        }
        System.out.println();
    }
}
