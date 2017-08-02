package com.algorithm.baseAlgorithm.run;

public class BitWise {
	public void Zero(){
		byte number =0;
		System.out.println(number);
		System.out.println(~number);
	}
	public void Shift(){
		byte number1 =1;
		System.out.println("正数移位：");
		System.out.println("左移：1 = "+(number1<<1));
		number1 =1;
		System.out.println("左移：2 = "+(number1<<2));
		number1 =2;
		System.out.println("右移：1 = "+(number1>>1));
		number1 =2;
		System.out.println("右移：2 = "+(number1>>2));
		
		short number2 =-1;
		System.out.println("负数移位：");
		System.out.println("左移：1 = "+(number2 <<9));
		number2 =-2;
		System.out.println("右移：2 = "+(number2 >>> 1));
		number2 =-8;
		System.out.println("右移：1 = "+(number2>>>1));
		number2 =(short)-1;
		System.out.println("右移：2 = "+((short)(number2>>>15)));
	}
}
