package com.algorithm.niukewang;

import java.util.Scanner;

/**
 * Created by wkhuahuo on 2017/3/7.
 */
public class Main2 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n =in.nextInt();
        int len = in.nextInt();

        if(len==1){
            System.out.print(n);
            return ;
        }else  if((n/len) ==0){
            System.out.println("No");
            return ;
        }else {
            setval( n, len);
            return;
        }


    }


    private static void setval(int n,int len) {

        int a = (n-(len*(len-1))/2);

        while(a%len !=0){
            len++;
            a = (n-(len*(len-1))/2);
            if(len>100){
                System.out.println("No");
                return;
            }
        }
        a = a/len;
        for(int i=a;i<a+len-1;i++){
            System.out.print(i+" ");
        }
        System.out.println(a+len-1);
    }




}
