package com.work.practice.mianshi.wangyi;

import java.util.Scanner;

/**
 * @author wangkai43
 * @create 2017-08-12-15:48
 * @email wangkai43@meituan.com
 */
public class QiZhiMain {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int nodes = in.nextInt();//房租x
        int[] x = new int[nodes];
        int[] y = new int[nodes];
        int num=0;
        while(num<nodes && in.hasNext() ){
            x[num++] = in.nextInt();
        }
        num = 0;
        while (num < nodes && in.hasNext()){
            y[num++] = in.nextInt();
        }
        int result = 0;
        for(int i=1;i<=nodes;i++) {
            int[] tmpx = new int[i];
            System.arraycopy(x,0,tmpx,0,tmpx.length);
            int[] tmpy = new int[i];
            System.arraycopy(x,0,tmpy,0,tmpy.length);
            result = minSteps(i, tmpx, tmpy);
            System.out.println(result);
        }
        System.out.println(result);

    }
    private static int minSteps(int nodes, int[] x, int[] y){
        int[] result = new int[nodes];
        result[0] = 0;

        int maxi =0;
        int mini = x[0];
        int maxj =0;
        int minj = y[0];

        for(int i=1;i<nodes;i++){
            maxi = x[i] > maxi ? x[i] : maxi;
            mini = x[i] < mini ? x[i] : mini;
            maxj = y[i] > maxj ? y[i] : maxj;
            minj = y[i] > minj ? y[i] : minj;
        }

        //平移x轴
        int[] Xresult = new int[nodes];
        int minIndex =x[0];
        int minSumX = Integer.MAX_VALUE;

        for (int pos = mini; pos < maxi; pos++) {
            int tmpSum = 0;

            for (int i = 0; i < nodes; i++) {
                tmpSum += Math.abs(x[i] - pos);
            }
            if (tmpSum < minSumX) {
                minSumX = tmpSum;
                minIndex = x[pos];
            }
        }
        System.out.println(minSumX);

        //平移y轴
        int[] Yresult = new int[nodes];
        minIndex =y[0];
        int minSumY = Integer.MAX_VALUE;

        for (int pos = mini; pos < maxi; pos++) {
            int tmpSum = 0;

            for (int i = 0; i < nodes; i++) {
                tmpSum += Math.abs(y[i] - pos);
            }
            if (tmpSum < minSumY) {
                minSumY = tmpSum;
                minIndex = y[pos];
            }
        }
        System.out.println(minSumY);


        return minSumX+minSumY;
    }


}
