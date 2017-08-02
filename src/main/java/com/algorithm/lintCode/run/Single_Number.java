package com.algorithm.lintCode.run;

/**
 * Created by wangkai43 on 2017/7/27.
 */
public class Single_Number {
    /**
     *@param A : an integer array
     *return : a integer
     */
    public int singleNumber(int[] A) {
        // Write your code here
        if(A==null || A.length == 0){
            return 0;
        }
        int result =A[0];
        for(int i=1;i<A.length;i++){
            result =result ^ A[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Single_Number sn = new Single_Number();

        int[] nums = {1,1,2};
        int result = sn.singleNumber(nums);
        System.out.println(result);
    }
}
