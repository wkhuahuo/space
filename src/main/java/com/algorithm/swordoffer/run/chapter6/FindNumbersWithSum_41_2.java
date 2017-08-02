package com.algorithm.swordoffer.run.chapter6;

import java.util.ArrayList;

/**
 * 时间限制：1秒 空间限制：32768K 热度指数：7622
 算法知识视频讲解
 题目描述
 输入一个递增排序的数组和一个数字S，在数组中查找两个数，是的他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 输出描述:
 对应每个测试案例，输出两个数，小的先输出。
 * Created by wkhuahuo on 2017/3/27.
 */
public class FindNumbersWithSum_41_2 {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if(array == null || array.length ==0){
            return arrayList;
        }
        int begin=0;
        int end=array.length-1;
        int tmpsum =array[begin]+array[end];
        int mim = sum*sum;

        while(begin<array.length && end>=0 && begin<end){
            if(tmpsum<sum){
                tmpsum -= array[begin];
                begin++;
                tmpsum += array[begin];
            }else if(tmpsum>sum){
                tmpsum -= array[end];
                end--;
                tmpsum+=array[end];
            }else{
                if(mim > array[begin]*array[end]){
                    arrayList.clear();
                    arrayList.add(array[begin]);
                    arrayList.add(array[end]);
                    mim =array[begin]*array[end];
                    tmpsum -=array[begin];
                    begin++;
                    end =begin;
                }
            }

        }

        return arrayList;
    }
}
