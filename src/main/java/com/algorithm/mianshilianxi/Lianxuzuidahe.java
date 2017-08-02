package com.algorithm.mianshilianxi;

import java.util.Scanner;

/**
 * Created by wkhuahuo on 10/01/17.
 */
public class Lianxuzuidahe {

    public  int  maxSumSequ(int n, int[] arr){
        int thisSum , maxSum;
        thisSum = maxSum =0;
        for(int i=0;i<n;i++){
            thisSum += arr[i];
            if(thisSum>maxSum){
                maxSum = thisSum;
            }
            if(thisSum <0){
                thisSum =0;
            }
        }

        return maxSum;
    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];

        String str = new Scanner(System.in).nextLine();
        String[] strArr = str.split(" ");
        for (int i=0 ;i< strArr.length;i++){
            arr[i] = Integer.valueOf(strArr[i]);
        }
       /* System.out.println(n);
        for(int i: arr) {
            System.out.println(i+",");
        }*/
        Lianxuzuidahe lian = new Lianxuzuidahe();
        int result =lian.maxSumSequ(n, arr);

    }
}
