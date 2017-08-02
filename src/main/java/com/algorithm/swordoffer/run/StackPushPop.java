package com.algorithm.swordoffer.run;

import java.util.Stack;

/*
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4，5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的） 
 */
public class StackPushPop {
	//34ms 503k
	public boolean IsPopOrder2(int [] pushA,int [] popA) {
		int indexOfPushA= 0;
		int indexOfPopA= 0;
		Stack<Integer> s = new Stack<Integer>();
		s.push(pushA[indexOfPushA++]);
		while(indexOfPushA<pushA.length){
			
			if(popA[indexOfPopA] == s.peek()){
				s.pop();
				indexOfPopA++;
			}else{
				s.push(pushA[indexOfPushA++]);
			}
		}
		while(!s.isEmpty()){
			if(popA[indexOfPopA] == s.peek()){
				indexOfPopA++;
			}
			s.pop();
		}
		if(indexOfPopA==popA.length){
			return true;
		}
		
		return false;
	}
	
	//26ms 503k
	public boolean IsPopOrder3(int [] pushA,int [] popA) {
		Stack<Integer> s = new Stack<Integer>();
		int ipop = 0;
		for(int ipush=0;ipush<pushA.length;ipush++){
			s.push(pushA[ipush]);
			while(!s.isEmpty() && s.peek()==popA[ipop]){
				s.pop();
				ipop++;
			}
		}
		if(s.isEmpty()){
			return true;
		}
		return false;
	}
	public boolean IsPopOrder(int [] pushA,int [] popA) {

		Stack<Integer> stack = new Stack<>();
		int j=0;
		for(int i=0;i<pushA.length;i++){
			stack.push(pushA[i]);
			while(stack.peek() == popA[j]){
				j++;
				stack.pop();
				if(stack.empty()){
					return true;
				}
			}

		}
		return false;
	}
}
