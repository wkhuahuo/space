package com.algorithm.swordoffer.run;

import java.util.ArrayList;
import java.util.Arrays;

public class ContinuesSequenceWithSum {
	
	
	public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
		
		ArrayList<ArrayList<Integer> > arrListArrList = new ArrayList<ArrayList<Integer>>();
		
		
		int small =1;
		int big = 2;
		int tmpSum = 0;
		int end = (sum+1)/2;
		if(sum<2){
			return arrListArrList;
		}
		while(small<=end && big<sum){
			ArrayList<Integer> arrListInteger = new ArrayList<Integer>();
			tmpSum = sequenceSum(small,big);
			if(tmpSum<sum){
				big++;
				tmpSum = sequenceSum(small,big);
			}else if(tmpSum>sum){
				tmpSum-=small;
				small++;	
			}else if(tmpSum == sum){
				arrListInteger= sequenceAdd(small,big);
				arrListArrList.add(arrListInteger);
				big++;
			}
		}
		return arrListArrList;
    }
	
	private int sequenceSum(int small, int big){
		int tmpsum=0;
		if(small>big) return -1;
		for(int i = small;i<=big;i++){
			tmpsum+=i;
		}
		return tmpsum;
	}
	private ArrayList<Integer> sequenceAdd(int begin,int end){
		int[] tmp = new int[end-begin+1];
	//	System.out.println(begin>end);
		for(int i=0;i<tmp.length;i++){
			tmp[i]=begin++;
		}
		ArrayList<Integer> arrlist = new ArrayList<Integer>();
		for(int i=0;i<tmp.length;i++){
			arrlist.add(tmp[i] );
		}
		System.out.println("+#+ "+Arrays.toString(tmp));
		return arrlist;
	}
}
