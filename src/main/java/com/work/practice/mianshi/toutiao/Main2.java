package com.work.practice.mianshi.toutiao;

import java.util.Scanner;

/**
 * Created by wkhuahuo on 2017/3/30.
 */
public class Main2 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String str = in.next();

        char[] chars = str.toCharArray();
        for(int i=0;i<chars.length;i++){
            if(chars[i] =='('){
                myPrintleft();
                if(i<chars.length){
                    System.out.println();
                }
            }else if(chars[i] == ')'){
                myPrintright();
            }

        }

    }
    private static void myPrintleft(){
        System.out.println("+-+");
        System.out.println("| |");
    }
    private static void myPrintright(){

        System.out.println("| |");
        System.out.println("+-+");
    }

}
