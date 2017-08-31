package com.work.practice.mianshi.huawei;

import java.util.Scanner;

/**
 * @author wangkai43
 * @create 2017-08-16-19:03
 * @email wangkai43@meituan.com
 */
public class HW1Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = null;

            str = in.nextLine();

        String[] stts = str.split(" ");
        if(isIllegal(stts)){
            System.out.println("-1");
        }else {
            int nums = sameNum(stts[0], stts[1]);
            System.out.println(nums);
        }

    }
    public static boolean isIllegal(String[] strs){
        if(strs == null || strs.length != 2){
            return true;
        }
        String tmpl = strs[0];
        String tmpr = strs[1];
        if(tmpl.length() != tmpr.length()){
            return true;
        }
        for(int i=0;i<tmpl.length();i++){
            if(tmpl.charAt(i)<'0' || tmpl.charAt(i)>'9'){
                return true;
            }
            if(tmpr.charAt(i)<'0' || tmpr.charAt(i)>'9'){
                return true;
            }
        }
        return false;
    }

    public static int sameNum(String str1, String str2){
        char[] left = str1.toCharArray();
        char[] right = str2.toCharArray();
        int maxLength = 0;
        int count = 0;

        for(int l=0;l<left.length;l++){
            for(int r=0;r<right.length ;r++ ){
                while(l+count<left.length && r+count<right.length &&left[l+count] == right[r+count]){
                    count++;
                    maxLength = maxLength> count? maxLength : count;
                }
                count =0;
                if(l+count == left.length ){
                    return maxLength;
                }
            }

        }

        return maxLength;
    }

}
