package com.algorithm.swordoffer.run.chapter6;

/**
 * 时间限制：1秒 空间限制：32768K 热度指数：7686
 本题知识点： 字符串
 算法知识视频讲解
 题目描述
 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，
 请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
 * Created by wkhuahuo on 2017/3/27.
 */
public class LeftRotate_42_1 {
    public String LeftRotateString(String str,int n) {
        if(str == null || str.length()<=1){
            return str;
        }
        n = n%str.length();
        char[] chars = str.toCharArray();
        inverse(chars,0, n-1);
        inverse(chars,n, chars.length-1);
        inverse(chars,0, chars.length-1);

        return String.valueOf(chars);
    }
    private  void inverse(char[] chars,int left, int right){
        char tmp ;
        while(left<right){
            tmp = chars[left];
            chars[left] = chars[right];
            chars[right] = tmp;
            left++;
            right--;
        }
    }
}
