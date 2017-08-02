package com.algorithm.swordoffer.run.Chapter5;

/**
 * Created by wkhuahuo on 2017/3/26.
 */
public class UglyNum_34 {
    public int GetUglyNumber_Solution(int index) {
        if(index<=0){
            return 0;
        }

        return getIndexth(index);
    }
    private int getIndexth(int index){
        if(index<1){
            return 0;
        }
        int[] arrUglys = new int[index];
        arrUglys[0] = 1;
        int multyNum2 = 0;
        int multyNum3 = 0;
        int multyNum5 = 0;
        int nextugly = 1;
        while(nextugly<index){
            int min = Math.min(Math.min(arrUglys[multyNum2]*2,arrUglys[multyNum3]*3),arrUglys[multyNum5]*5);
            arrUglys[nextugly] = min;

            while (arrUglys[multyNum2]*2 <= arrUglys[nextugly]){
                multyNum2++;
            }
            while (arrUglys[multyNum3]*3 <=arrUglys[nextugly]){
                multyNum3++;
            }
            while (arrUglys[multyNum5]*5 <= arrUglys[nextugly]){
                multyNum5++;
            }
            nextugly++;
        }
        return arrUglys[nextugly-1];
    }
}
