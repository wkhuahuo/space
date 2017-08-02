package com.algorithm.swordoffer.test;

import com.algorithm.swordoffer.run.Chapter3.ReorderOddEven;

public class ReverOddEvenTest {
	public static void main(String[] args){
	//	int[] arr = {};
	//	int[] arr = {1,2,3,4,5,6,7,8,9};
		int[] arr = {1,11,3,6,5,43,7,22,9};
		ReorderOddEven reorder = new ReorderOddEven();
		reorder.reOrderArray4(arr);
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+",");
		}
	}
}
