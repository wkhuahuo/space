package com.algorithm.niukewang;

import java.util.ArrayList;

/**
 * Created by wkhuahuo on 2017/3/7.
 */
public class SuShu {
    public static void main(String[] args){
        long ll = 10000;
        ArrayList<Long> al = new ArrayList<>();
        for(long l =0;l<=ll;l++){
            if(isPrime(l)){
                al.add(l);
            }
        }

        System.out.printf(al.toString());
    }
    public static boolean isPrime(long a) {
        if (a < 2) return false;
        else for (long i = 2; i <= Math.sqrt(a); i++)
            if (a % i == 0) return false;
        return true;
    }
}
