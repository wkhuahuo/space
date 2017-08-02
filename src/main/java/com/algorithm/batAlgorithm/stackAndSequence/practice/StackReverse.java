package com.algorithm.batAlgorithm.stackAndSequence.practice;

import java.util.Stack;

/**
 * Created by wkhua on 16/12/14.
 */
public class StackReverse {
    public int[] reverseStack(int[] A, int n) {
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<A.length;i++){
            stack.push(A[i]);
        }
        for(int i=0;i<A.length;i++){
            stack.push(get(stack));
        }
        for(int i=0;i<A.length;i++){
            A[i] = stack.pop();
        }


        return A;
    }

    public Integer get(Stack<Integer> stack){
        int result =stack.pop() ;
        if(stack.isEmpty()){
            return result;
        }else{
            int i = get(stack);
            stack.push(result);
            return i;
        }
    }

}
