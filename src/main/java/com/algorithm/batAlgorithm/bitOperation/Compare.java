package com.algorithm.batAlgorithm.bitOperation;

/**
 * Created by wkhuahuo on 17/02/17.
 */
public class Compare {
    private int flip(int n){//将当前符号取反
        return n^1;
    }
    private int sign(int a){//得到a的符号位 正为1 负为0
        return flip((a>>31)&1);
    }
    public int getMax(int a, int b) {

        int sa = flip(sign(a));//正为0
        int sb = flip(sign(b));
        int dif = sa^sb;//不同为1, 相同为0
        int same = flip(dif);//将相同变为1

        int c = a*sa*dif+b*sb*dif;

        return same*a*flip(sign(b-a))+same*b*sign(b-a)+c;
    }


    public int getMax1(int a, int b) {

        int signc = sign(a-b);
        return a*flip(signc)+b*signc;
    }
}
