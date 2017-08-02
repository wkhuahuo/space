package com.algorithm.batAlgorithm.string;

/**
 * Created by wkhua on 16/12/13.
 */
public class Parenthesis {
    public boolean chkParenthesis(String A, int n) {

        int left =0;
    //   boolean previous = true;//true:left; false:right;
        for(int i=0;i<n;i++){
            if(A.charAt(i) == '('){
                left++;
//                if(!previous){
//                    previous = true;
//                }
            }else if(A.charAt(i) == ')'){
//                previous = false;

                if(left<=0){
                    return false;
                }
                left--;

            }else{
                return false;
            }
        }
        return true;
    }
}
