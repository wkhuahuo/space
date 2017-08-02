package com.work.practice.mianshi.wangyi;

import java.util.Scanner;

/**
 * Created by wkhuahuo on 2017/3/25.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int a = in.nextInt();//魔数个数
        int times = in.nextInt();//循环使用次数
        long[] arr = new long[a];
        int index=0;

        while( index < a) {

            arr[index]= in.nextInt();
            index++;
        }
        while (times>0) {
            increase(arr);
            times--;
        }
        print(arr);
    }
    private static void increase(long[] arr){
        long a0 = arr[0];
        for(int i=0;i<arr.length;i++){

            if(i == arr.length-1){
                arr[i] = arr[i]+a0;
                if(arr[i]>=100){
                    arr[i] = arr[i]%100;
                }
            }else {
                arr[i] += arr[i + 1];
                if(arr[i]>=100){
                    arr[i] = arr[i]%100;
                }
            }
        }
    }
    private  static void print(long[] arr){
        if(arr == null || arr.length == 0){
            return;
        }
        for(int i=0;i<arr.length-1;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println(arr[arr.length-1]);
    }
}
