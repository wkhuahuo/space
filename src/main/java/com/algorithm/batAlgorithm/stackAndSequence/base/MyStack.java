package com.algorithm.batAlgorithm.stackAndSequence.base;

import java.util.Stack;

/**
 * Created by wkhua on 16/12/14.
 */
public class MyStack {
    Stack<Integer> stack = new Stack();
    Stack<Integer> minStack = new Stack();
    public void push(int node) {
        stack.push(node);
        if(minStack.isEmpty()||(node<=minStack.peek())){
            minStack.push(node);
        }
    }

    public void pop() {
        if(stack.isEmpty()){
            return;
        }
        if(stack.peek()==minStack.peek()){
            minStack.pop();
        }
        stack.pop();
    }

    public int top() {

        return stack.peek();

    }

    public int min() {

        return minStack.peek();
    }
}
