package com.algorithm.swordoffer.run;

import java.util.ArrayList;

public class Clockwisely {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
    	if(matrix ==null) return null;
    	
    	int start=0;
    	int row = matrix.length;//��
    	int column = matrix[0].length;//��
    	
    	ArrayList<Integer> arrayList=new ArrayList<Integer>();
    	while(row>start*2 && column>start*2){
    		myPrint(arrayList,column, row, start, matrix);
    		++start;
    	}
		return arrayList;
	       
	  
	}

	private void myPrint(ArrayList<Integer> arrayListint,int column, int row, int start, int[][] matrix) {
		// TODO Auto-generated method stub
		int endX = column-1-start;
		int endY = row-1-start;
		
		if(endX>=start){//��
			for(int i=start;i<=endX;i++){
				arrayListint.add(matrix[start][i]);
			}

		}
		if(endY>start){//��
			for(int i=start+1;i<=endY;i++){
				arrayListint.add(matrix[i][endX]);
			}
			
		}
		if(endY>start&& endX>start){//��
			for(int i=endX-1;i>=start;i--){
				arrayListint.add(matrix[endY][i]);
			}
		}
		if(endY>start+1 && endX>start){//��
			for(int i=endY-1;i>=start+1;i--){
				arrayListint.add(matrix[i][start]);
			}
		}
		
	}
   
    
}
