package com.game.mineSweeping;

/**
 * @author wangkai43
 * @create 2017-09-30-18:19
 * @email wangkai43@meituan.com
 */
public class PrintUtils {
    public static void printArray(int[][] arrs){
        System.out.print("# \t");
        for(int i=0;i<arrs.length-1;i++){
            System.out.print(i+"\t");
        }
        System.out.println(arrs.length-1);
        for(int i=0;i<arrs.length;i++){
            System.out.print(i+"\t");
            for(int j=0;j<arrs[0].length-1;j++){

                System.out.print(arrs[i][j]+"\t");
            }
            System.out.println(arrs[i][arrs[0].length-1]);
        }

    }
    public static void printArray(int[] arr){
        for(int i=0;i<arr.length;i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void printLine(){
        System.out.println("=========");
    }
}
