package com.work.practice.mianshi.wangyi;

import java.util.Scanner;

/**
 * @author wangkai43
 * @create 2017-08-12-14:53
 * @email wangkai43@meituan.com
 */
public class XZmain {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int fz = in.nextInt();//房租x
        int sg = in.nextInt();//手中果f
        int money = in.nextInt();//手中钱d
        int sgdj = in.nextInt();//果单价p

        int days = getDays(fz, sg, money, sgdj);
        System.out.println(days);


    }
    private static int  getDays(int fz,int sg, int money, int sgdj){
        int days = 1;
        if(money<=0){
            return 0;
        }
        days = money/fz;
        if(days <=sg){
            return days;
        }
        days = sg;
        money -= days*fz;
        days += money /(fz + sgdj);
        return days;

    }

}
