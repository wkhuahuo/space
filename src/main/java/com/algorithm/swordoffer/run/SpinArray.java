package com.algorithm.swordoffer.run;

public class SpinArray {
	 
	public int minNumberInRotateArray(int [] array) {
		if(array==null || array.length==0){
			return 0;
		}
		int iLeft=0;
		int iRight=array.length-1;
		int iMid=0;
		
		while(iRight-iLeft>1){
			iMid=(iRight-iLeft)/2;
			if(array[iMid]>array[iLeft]){
				iLeft = iMid;
			}
			if(array[iMid]<array[iRight]){
				iRight = iMid;
			}
			if(array[iMid] == array[iLeft] || array[iMid] == array[iRight]){
				int leftmin = 0;
				int rightmin = 0;
				leftmin = findMinLR(iLeft,iMid,array);
				rightmin = findMinLR(iMid,iRight,array);
				return (leftmin>=rightmin) ? rightmin:leftmin;
			}
				
			System.out.println(iMid);
		}
		
		 
		return array[iLeft];
	 }
	
	private int findMinLR(int left, int right, int [] array){
		int min = array[right];
		for(int itmp=left;itmp<right ;itmp++){
			if(array[itmp]<min){
				min = array[itmp];
			}
		}
		return min;
	}
}
