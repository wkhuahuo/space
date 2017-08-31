package com.algorithm.lintCode.run;

import java.util.Stack;

/**
 * @author wangkai43
 * @create 2017-08-31-10:58
 * @email wangkai43@meituan.com
 */
public class MinStack2 {
    Stack<Integer> stack = new Stack();
    Stack<Integer> minValueStack = new Stack<>();
    public MinStack2() {
        // do initialize if necessary
    }

    //当push的值与当前最小值相同时不把值推进minValueStack
    public void push(int number) {
        // write your code here
        stack.push(number);
        if(minValueStack.isEmpty() || number <= minValueStack.peek()){
            minValueStack.push(number);
        }
    }

    public int pop() {
        int value = -1;
        if(!stack.isEmpty()) {
            value = stack.pop();
        }
        if(!minValueStack.isEmpty() && value == minValueStack.peek()){
            minValueStack.pop();
        }
        return value;
    }

    public int min() {
        // write your code here
        return minValueStack.isEmpty()? -1: minValueStack.peek();
    }
}
