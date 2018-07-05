package com.work.practice.mianshi.meilishuo;

import java.util.Scanner;

/**
 * @author wangkai43
 * @create 2017-09-23-14:48
 * @email wangkai43@meituan.com
 */
public class MeiLieShuo {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            int nian = in.nextInt();
            int yue = in.nextInt();
            int ri = in.nextInt();

            System.out.println(calculate(nian,yue,ri));
        }
    }

    public static int calculate(int nian ,int yue, int ri){
        boolean isRuiNian = false;
        if(nian%4 == 0 ||nian %200 == 0){
            isRuiNian = true;
        }
        int days=0;
        switch (yue-1)
        {
            case 12: days+=31;
            case 11: days+=30;
            case 10: days+= 31;
            case 9: days+=30;
            case 8: days+=31;
            case 7: days+=31;
            case 6: days+=30;
            case 5: days+=31;
            case 4: days+=30;
            case 3: days+=31;
            case 2: days+=isRuiNian ? 29: 28;
            case 1: days+=31;
        }
        days+=ri;
        return days;

    }
}
