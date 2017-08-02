package com.algorithm.swordoffer.run.chapter6;

/**
 * 时间限制：1秒 空间限制：32768K 热度指数：7827
 本题知识点： 数组
 算法知识视频讲解
 题目描述
 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * Created by wkhuahuo on 2017/3/27.
 */
public class AppearanceOnce_40 {
    //num1,num2分别为长度为1的数组。传出参数
    //将num1[0],num2[0]设置为返回结果
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array == null || array.length ==0){
            return;
        }
        int result =0;
        for(int i=0;i<array.length;i++){
            result ^= array[i];
        }
        int index =1;
        while((result&index) == 0){
            index =index << 1;
        }
        num1[0] = result;
        for(int i=0;i<array.length;i++){
            if((array[i] & index) != index) {
                result ^= array[i];
            }
        }
        num2[0] = result;
        num1[0] = num1[0]^result;
    }

}
