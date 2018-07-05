package com.work.practice.mianshi.didi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author wangkai43
 * @create 2017-09-10-16:00
 * @email wangkai43@meituan.com
 */
public class DiDiQuJian {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int[] arr = new int[num];

        for(int i=0; i<num;i++){
            arr[i] =  in.nextInt();
        }

        Arrays.sort(arr);

        System.out.println(getNums(arr));
    }
    public static int getNums(int[] arr){
        int count = 0;
        int begin =0;

        int length =1;
        for(int i = 0; i< arr.length; i++){
            int tmp =0;

            for (int j=0;j<length;j++){
                tmp = tmp ^ arr[i+j];
            }

            if(tmp ==0 ){
                i = i+length;
                count ++;
            }
        }
        return count;
    }

}
