package com.algorithm.swordoffer.run.Chapter7;

/**
 * 时间限制：1秒 空间限制：32768K 热度指数：3871
 本题知识点： 字符串
 算法知识视频讲解
 题目描述
 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 * Created by wkhuahuo on 2017/3/30.
 */
public class StringtoNum {

    /***
     * e+6也被判为合法
     * @param str
     * @return
     */
    public boolean isNumeric(char[] str) {
        if(str == null || str.length==0){
            return false;
        }
        int index=0;
        index = isNatureNum(str,index);
        if(index<str.length &&(str[index] =='e' || str[index] == 'E')){
            index++;
            if(index == str.length){
                return false;
            }
            index =isInteger(str,index);
        }
        if(index == str.length){
            return true;
        }

        return false;
    }
    //判断是否是带符号整数
    private int isInteger(char[] str, int index){
        if(index>=str.length){
            return index;
        }
        if(index<str.length &&  (str[index] =='+'||str[index]=='-')){
            index++;
        }
        while(index<str.length && isNum(str[index])){
            index++;
        }
        return index;
    }

    //判断是否是一个正常的小数
    private int isNatureNum(char[] str,int index){
        if(index<str.length && (str[index] =='+'||str[index]=='-')){
            index++;
        }
        index = isNormalNum(str,index);
        return index;
    }

    //判断是否是一个正常的不带符号的小数
    private int isNormalNum(char[] str,int index){
        if(index>=str.length){
            return index;
        }
        while(index<str.length && index<str.length &&isNum(str[index])){
            index++;
        }

        if(index<str.length && index<str.length && str[index] =='.'){
            index++;
        }
        while(index<str.length && isNum(str[index])){//结尾必须是数字
            index++;
        }

        return index;
    }

    //判断是否是一个数
    private boolean isNum(char ch){
        if(ch-'0'<=9 && ch -'0'>=0){
            return true;
        }else{
            return false;
        }
    }




}
