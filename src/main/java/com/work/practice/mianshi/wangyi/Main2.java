package com.work.practice.mianshi.wangyi;

import java.util.Scanner;

/**
 * Created by wkhuahuo on 2017/3/25.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String str  = in.next();//

        adapt(str);


    }
    private static void adapt(String str){
        if(str == null || str.length() == 0){
            return ;
        }
        if(str.length()<3) System.out.print("0");
        char[] queue = str.toCharArray();
        int length = queue.length;
        int count1 =0;
        int count2 = 0;
        for(int i=0;i<length;i++){
            if(queue[i] == 'G'){
                for(int j=i+1;j<length;j++){
                    count1 +=queue[j] == 'B'? 1:0;
                }
            }else{
                for(int j=i+1;j<length;j++){
                    count2 += queue[j] == 'G'?1:0;
                }
            }
        }
        int res = Math.min(count1,count2);
        System.out.println(res);
    }
}
