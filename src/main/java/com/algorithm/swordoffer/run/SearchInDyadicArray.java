package com.algorithm.swordoffer.run;

public class SearchInDyadicArray {
    public boolean Find(int [][] array,int target) {
    	
    	if(array==null){
    		return false;
    	}
    	int length = array.length;
    	int i = length-1;
    	int j = 0;
    	while(i>=0&&j<array[i].length){
        	if(array[i][j]==target){
        		return true;
        	}
        	if(array[i][j]>target){
        		i--;
        	}else if(array[i][j]<target){
        		j++;
        	}
        	
        	
        }
        return false;
    }
}
