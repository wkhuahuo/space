package com.algorithm.swordoffer.test;

import java.util.ArrayList;

import com.algorithm.swordoffer.run.Clockwisely;

public class ClockwiselyTest {
	public static void main(String[] args){
		
//		int [][] matrix ={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		int [][] matrix = {{1},{2},{3},{4},{5}};
		ArrayList<Integer> intArrList = new ArrayList<Integer>();
		System.out.println(matrix.length+"��\n"+matrix[0].length+"��\n");
		Clockwisely cw = new Clockwisely();
		intArrList = cw.printMatrix(matrix);
		System.out.println(intArrList.toString());
	}
}
