package com.algorithm.swordoffer.run.Chapter3;


import java.util.Arrays;
import java.util.Comparator;

public class ReorderOddEven {
	public void reOrderArray(int [] array) {
		if(array == null )return;
		int[] oddArr  = new int[array.length];
		int[] evenArr = new int[array.length];
		int oddindex =0;
		int evenindex =0;
		for(int i=0;i<array.length;i++){
			if((array[i] & 0x01) == 1){//奇数
				oddArr[oddindex++] = array[i];
			}else {
				evenArr[evenindex++] = array[i];
			}
		}
		for(int i=0;i<oddindex;i++){
			array[i] = oddArr[i] ;
		}
		for(int i=0;i<evenindex;i++){
			array[i+oddindex] = evenArr[i];
		}

	}
	 public void reOrderArray_1(int [] array) {
		 if (array == null) return;
		 int[] oddArr = new int[array.length];
		 int[] evenArr = new int[array.length];
		 int i_even=0;
		 int i_odd=0;
		 for(int i=0;i<array.length;i++){
			 if(array[i]%2==0){
				 evenArr[i_even] = array[i];
				 i_even++;
			 }else{
				 oddArr[i_odd] = array[i];
				 i_odd++;
			 }
		 }
		 for(int i=0;i<i_odd;i++){
			 array[i]=oddArr[i];
		 }
		 for(int i=0;i<i_even;i++){
			 array[i+i_odd]=evenArr[i];
		 }
	 }

	 //====================================================


	 public void reOrderArray1(int [] array) {
		 if (array == null) return;
		 int i_even=0;
		 int i_odd=0;
		 Arrays.sort(array);
		 
		 for(int i =0; i< array.length; i++){
			 if(array[i]%2==0){
				 i_odd= i;
				 break;
			 }
		 }
		 while(i_odd< array.length){
			 if(array[i_odd]%2 == 0){//如果不是奇数就前进
				 i_odd++;
			 }else if(i_even<i_odd && array[i_even]%2 != 0){
				 i_even++;
				 move(i_odd, i_even, array);
			 }
		 }
	 }

	public void move(int i_odd, int i_even, int[] array) {
		// TODO Auto-generated method stub
		int tmp = array[i_odd];
		for(int i = i_odd; i> i_even; i--){
			array[i]=array[i-1];
		}
		array[i_even] = tmp;
	}
	
	class OddEvenComparator implements Comparator<Integer>{

		@Override
		public int compare(Integer o1, Integer o2) {
			// TODO Auto-generated method stub
			if(o1%2==1&& o2%2 ==0){
				return -1;
			}else if(o1%2==0 && o2%2 == 1){
				return 1;
			}else{
				return 0;
			}
			
		}
		
	}
	public void reOrderArray3(int [] array) {
		
		Integer[] tmparr = new Integer[array.length];
		for(int i=0;i<array.length;i++){
			tmparr[i] = array[i]; 
		}
		Arrays.sort(tmparr,new OddEvenComparator());
		
		for(int i=0;i<array.length;i++){
		//	System.out.println(tmparr[i]);
			array[i] = tmparr[i]; 
		}
	}
	
	
	public  int[] sort(int[] array,int begin, int end){
		int mid = (begin+end)/2;
		if(begin< end){
		//归并左半部分
			sort(array,begin,mid);
		//归并右半部分
			sort(array,mid+1,end);
		//排序
			merge(array,begin,mid,end);
		}
		return array;
	}
	private  void merge(int[] array, int begin, int mid, int end ){
		int[] tmparr = new int[end-begin+1];
		int ibegin =begin;
		int jmid = mid+1;
		int ktmparr = 0;
		
		while(ibegin<=mid&&jmid<=end){
			if(array[ibegin]%2==1 && array[jmid]%2==0){
				tmparr[ktmparr++] = array[ibegin++];
			}else if(array[ibegin]%2==0 && array[jmid]%2==1){
				tmparr[ktmparr++] = array[jmid++];
			}else{
				tmparr[ktmparr++] = array[ibegin++];
			}
		}
		while(ibegin<=mid){
			tmparr[ktmparr++] = array[ibegin++];
		}
		while(jmid<=end){
			tmparr[ktmparr++] = array[jmid++];
		}
		for(int i = 0;i<tmparr.length;i++){
			array[begin+i] = tmparr[i];
		}
	}
	
	
	public void reOrderArray4(int [] array) {
		int begin = 0;
		int end = array.length-1;
		
		sort(array,begin,end);
		
	}

	
	
}
