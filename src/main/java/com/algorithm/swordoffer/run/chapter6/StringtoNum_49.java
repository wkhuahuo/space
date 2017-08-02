package com.algorithm.swordoffer.run.chapter6;

/**
 * 时间限制：1秒 空间限制：32768K 热度指数：6261
 本题知识点： 字符串
 算法知识视频讲解
 题目描述
 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 输入描述:
 输入一个字符串,包括数字字母符号,可以为空


 输出描述:
 如果是合法的数值表达则返回该数字，否则返回0

 输入例子:
 +2147483647
 1a33

 输出例子:
 2147483647
 0
 *
 * Created by wkhuahuo on 2017/3/28.
 */
public class StringtoNum_49 {
    public int StrToInt(String str) {
        if(str == null || str.length() == 0){
            return 0;
        }
        int num=0;
        char[] chars = str.toCharArray();

        if(chars[0] =='+'){
            num =shouleBeNum(chars, 1,chars.length-1);
        }else if(chars[0] =='-'){
            num = - shouleBeNum(chars, 1,chars.length-1);
        }else{
            num =shouleBeNum(chars, 0,chars.length-1);
        }

        return num;
    }
    private int shouleBeNum(char[] chars, int begin, int end){
        int num = 0;
        int tmp ;
        for(int i=begin;i<=end;i++){
            tmp =chars[i]-'0';
            if(tmp>=0 && tmp<=9){
                if(i<end) {
                    num += tmp;
                    num *= 10;
                }else{
                    num +=tmp;
                }
            }else{
                return 0;
            }
        }

        return num;
    }
}
