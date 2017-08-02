package com.algorithm.batAlgorithm.string;

/**
 * Created by wkhua on 16/12/7.
 */
public class Rotation {
    public boolean chkRotation(String A, int lena, String B, int lenb) {
        String doubleA = A+A;
        int index =BaseStringUtil.KMP(doubleA,B,0 );
                //doubleA.contains(B);
        if(index>=0){
            return true;
        }
        return false;
    }
}
