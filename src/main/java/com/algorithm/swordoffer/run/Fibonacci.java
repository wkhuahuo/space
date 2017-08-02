package com.algorithm.swordoffer.run;

public class Fibonacci {
	public int recursion_fibonacci(int n){
		if(n==0){
			return 0;
		}
		if(n==1){
			return 1;
		}
		return recursion_fibonacci(n-1)+recursion_fibonacci(n-2);
	}
	
	public int fibonacci(int n){
		int sum=0;
		int pretmp = 0;
		int tmp=1;
		if(n==0) return 0;
		if(n==1) return 1;
		while(n-->1){
			sum = tmp+pretmp;
			pretmp=tmp;
			tmp=sum;
			
		}
		return sum;
	}
}
