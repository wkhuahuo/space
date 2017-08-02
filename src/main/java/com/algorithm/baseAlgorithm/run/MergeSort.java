package com.algorithm.baseAlgorithm.run;

/**
 * �鲢����
 * @author wkhuahuo
 *ʵ�ֹ鲢����
 */
public class MergeSort {
	
	public static void sort(int[] array){
		int begin = 0;
		int end = array.length-1;
		
		sort(array,begin,end);
	}
	public static int[] sort(int[] array,int begin, int end){
		int mid = (begin+end)/2;
		if(begin< end){
		//�鲢��벿��
			sort(array,begin,mid);
		//�鲢�Ұ벿��
			sort(array,mid+1,end);
		//����
			merge(array,begin,mid,end);
		}
		return array;
	}
	private static void merge(int[] array, int begin, int mid, int end){
		int[] tmparr = new int[end-begin+1];
		int ibegin =begin;
		int jmid = mid+1;
		int ktmparr = 0;
		
		while(ibegin<=mid&&jmid<=end){
			if(array[ibegin]<=array[jmid]){
				tmparr[ktmparr++] = array[ibegin++];
			}else{
				tmparr[ktmparr++] = array[jmid++];
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
	
}
