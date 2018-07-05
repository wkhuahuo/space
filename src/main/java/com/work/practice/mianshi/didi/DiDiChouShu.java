package com.work.practice.mianshi.didi;

import java.util.Scanner;

/**
 * @author wangkai43
 * @create 2017-09-10-15:45
 * @email wangkai43@meituan.com
 */
public class DiDiChouShu {

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        int num = in.nextInt();

        System.out.println(getKthUglyNum(num));
    }

    public static boolean isUgly(int num){
        while (num % 2 == 0)
            num/=2;
        while (num % 3 == 0)
            num /=3;
        while (num % 5 == 0)
            num /=5;
        return (num ==1)? true:false;
    }
    public static  int getKthUglyNum(int kth){
        if(kth <= 0)
            return 0;

        int num = 0;

        int ugly = 0;
        while(ugly < kth){
            num++;
            if(isUgly(num)){
                ++ugly;
            }
        }
        return num;
    }

}
