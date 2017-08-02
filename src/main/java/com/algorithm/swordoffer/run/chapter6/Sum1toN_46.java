package com.algorithm.swordoffer.run.chapter6;

/**
 *
 * 时间限制：1秒 空间限制：32768K 热度指数：7901
 算法知识视频讲解
 题目描述
 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。

 解题思路：1.需利用逻辑与的短路特性实现递归终止。 2.当n==0时，(n>0)&&((sum+=Sum_Solution(n-1))>0)只执行前面的判断，为false，然后直接返回0；3.当n>0时，执行sum+=Sum_Solution(n-1)，实现递归计算Sum_Solution(n)。
 * Created by wkhuahuo on 2017/3/28.
 */
public class Sum1toN_46 {

    public int Sum_Solution(int n) {

        int sum=n;
        boolean flag =(n>0 && (sum+=Sum_Solution(--n))>0);

        return sum;
    }
}
