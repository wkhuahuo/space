package com.algorithm.swordoffer.run.Chapter7;

/**
 * Created by wkhuahuo on 2017/3/28.
 */
public class MultiArray_51 {
    public int[] multiply(int[] A) {
        if(A == null || A.length ==0){
            return A;
        }
        int[] B = new int[A.length];
        B[0] = 1;
        for(int i=1;i<A.length;i++){
            B[i] =B[i-1]*A[i-1];
        }
        int C =1;
        for (int i=A.length-2;i>=0;i--){
            C = C*A[i+1];
            B[i] = B[i]*C;
        }

        /*int[] C = new int[A.length];
        C[A.length-1] = 1;
        for(int i=A.length-2;i>=0;i--){
            C[i] = C[i+1]*A[i+1];
        }
        for (int i=0;i<B.length;i++){
            B[i] = B[i] *C[i];
        }
*/
        return B;

    }
}
