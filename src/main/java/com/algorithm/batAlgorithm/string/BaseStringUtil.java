package com.algorithm.batAlgorithm.string;

/**
 * Created by wkhua on 16/12/8.
 */
public class BaseStringUtil {
    public static int KMP(String T, String P, int startedPos){
        int[] next = myIndexArr3(P);
        int iA = startedPos;
        int jB = 0;
        while(iA < T.length() && jB < P.length()){
            if(jB==-1 || T.charAt(iA) ==P.charAt(jB)){
                iA++;
                jB++;
            }else{
                jB = next[jB];
            }
        }
        if(jB >= P.length()){
            return iA - P.length();
        }else{
            return -1;
        }
    }

    /*示例程序
    public static int[] indexArr(String P){

        int[] next = new int[P.length()+1];
        //初始条件
        int ind = 1;
        int pre = 0;
        next[0] = 0;
        next[1] = 0;
        for(;ind<P.length();ind++) {
            while(pre>0 && P.charAt(ind) != P.charAt(pre)){
                pre = next[pre];
            }
            if(P.charAt(ind) == P.charAt(pre)){
                pre++;
            }
            next[ind+1] = pre;
        }
        return next;
    }*/

    public static int[] myIndexArr(String P){

        int[] next = new int[P.length()];
        //初始条件
        int ind = 0;
        int pre = -1;
        next[0] = -1;

     /* 实现*/
        while(ind<P.length()-1) {
           if(pre ==-1 || P.charAt(ind) == P.charAt(pre)){

               next[++ind] = ++pre;

           }else{
               pre = next[pre];
           }
       }

        return next;
    }

    public static int[] myIndexArr2(String P){
        int[] next = new int[P.length()];
        //初始条件
        int ind = 0;
        int pre = -1;
        next[0] = -1;
        while(ind<P.length()-1) {
            if (pre == -1 || P.charAt(ind) == P.charAt(pre)) {
                if(P.charAt(ind+1)==P.charAt(pre+1)){
                    next[++ind] = next[++pre];
                }else {
                    next[++ind] = ++pre;
                }
            } else {
                pre = next[pre];
            }
        }
        return next;
    }

    public static int[] myIndexArr3(String P){
        int[] next = new int[P.length()];
        //初始条件
        int ind = 0;
        int pre = -1;
        next[0] = -1;
        while(ind<P.length()-1) {
            if (pre == -1 || P.charAt(ind) == P.charAt(pre)) {

                if(P.charAt(ind+1) !=P.charAt(pre+1)){
                    next[++ind] = ++pre;
                }
                while(ind<P.length()-1 && P.charAt( ind+1)==P.charAt(pre+1)){
                    next[ ++ind] = next[++pre];
                }
            } else {
                pre = next[pre];
            }
        }
        return next;
    }
}
