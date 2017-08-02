package com.algorithm.swordoffer.run;

public class Power {
	   
	public double power(double base, int exponent) {
		boolean negative = false;
		if(base == 0){
			return 0;
		}
		if(exponent==0){
			return 1;
		}
		if(exponent <0){
			negative =true;
			exponent = -exponent;
		}
		if(negative==false){
			return powerPositive(base,exponent);
		}else{
			return 1/powerPositive(base,exponent);
		}
	        
	}
	
	private double powerPositive(double base, int exponent){//base非零 exponent为正数
		if(exponent==0){
			return 1;
		}
		if(exponent%2==1){
			return powerPositive(base,exponent/2)*powerPositive(base,exponent/2)*base;
		}else{
			return powerPositive(base,exponent/2)*powerPositive(base,exponent/2);
		}
	}
}
