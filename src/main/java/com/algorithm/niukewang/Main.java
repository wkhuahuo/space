package com.algorithm.niukewang;

import java.util.Scanner;

/**
 * Created by wkhuahuo on 2017/3/7.
 */
public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        long maxNum =(long) Math.pow(10,18);
        int q = 2;

        if(n>=2 && n<=maxNum) {
            do {
                int num = (int) Math.pow(n, (1.0 / q));

                if (Math.abs(Math.pow(num,q)-n)<0.000001 && isPrime(num)) {

                        System.out.println(num + " " + q);
                        return;
                }
                q++;
            } while (q<=n);
        }
        System.out.println("No");


    }
    public static boolean isPrime(long a) {
        if (a < 2) return false;
        else for (long i = 2; i <= Math.sqrt(a); i++)
            if (a % i == 0) return false;
        return true;
    }
}
