package com.algorithm.swordoffer.run;

import java.util.Stack;
public class StackWithMin {
	private Stack<Integer> stack = new Stack<Integer>();
	private Stack<Integer> minStack = new Stack<Integer>();
	int a = 0;
	public void push(int node) {
        if(minStack.isEmpty()||minStack.peek()>node){
        	minStack.push(node);
        }
        stack.push(node);
    }
    
    public void pop() {
    	 if(!stack.isEmpty()){
	    	if(minStack.isEmpty()||minStack.peek()!=stack.peek()){
	    		stack.pop();
	    	}else{
	    		stack.pop();
	    		minStack.pop();
	    	}
    	}
    }
    
    public int top() {
    	
		return stack.peek();
        
    }
    
    public int min() {
    	
    	return minStack.peek();
    }
}





    
    