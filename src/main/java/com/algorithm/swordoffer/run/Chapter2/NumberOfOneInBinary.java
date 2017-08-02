package com.algorithm.swordoffer.run.Chapter2;

/***
 * 时间限制：1秒 空间限制：32768K 热度指数：19127
 算法知识视频讲解
 题目描述
 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class NumberOfOneInBinary {
	public int _1_numberOf1(int n){
		int flag=1;
		int count =0;
		while(flag!=0){
			if((n&flag)!=0) {
                count++;
            }
            flag <<= 1;
		}
		return count;
	}
	public int numberOf1(int n){
		int count =0;
		while(n!=0){
			n=n&(n-1);
			count++;
		}
		return count;
	}
	
}
