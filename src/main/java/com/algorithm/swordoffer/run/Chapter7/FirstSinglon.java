package com.algorithm.swordoffer.run.Chapter7;

/**
 * 时间限制：1秒 空间限制：32768K 热度指数：4586
 本题知识点： 字符串
 算法知识视频讲解
 题目描述
 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 输出描述:
 如果当前字符流没有存在出现一次的字符，返回#字符。
 * Created by wkhuahuo on 2017/3/30.
 */
public class FirstSinglon {
    private int[] chs = new int[256];//默认是0
    //Insert one char from stringstream
    int index =1;
    public void Insert(char ch){
        if(chs[ch] >0){//如果已经不为零，那么说明已经出现了一次，这次应该为负数。
            chs[ch] = -2;
        }else {
            chs[ch] = index;//如果没有被标记过，做标记。index越小说明是越早出现。
            index++;
        }

    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()//寻找大于零而且是最小的标记。
    {
        int min = -2;
        int tmp = index;
        for(int i=0;i<chs.length;){
            while(i<chs.length && chs[i]<=0){
                i++;
            }
            if(i<chs.length) {
                if (tmp > chs[i]) {
                    tmp = chs[i];
                    min = i;
                }
                i++;
            }
        }
        if(min == -2){
            return '#';
        }else{
            return (char)min;
        }
    }
}
