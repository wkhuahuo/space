package com.algorithm.batAlgorithm.stackAndSequence.practice;

import org.junit.Test;

import java.util.Stack;

/**
 * Created by wkhua on 16/12/14.
 */
public class StackReverseTest {
    @Test
    public void getTest(){
        StackReverse sr = new StackReverse();
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        int a = sr.get(stack);
        System.out.println(a);
    }

    @Test
    public void reverseStackTest(){
        int[] A = {4,3,2,1};
        StackReverse st = new StackReverse();
        A = st.reverseStack(A,A.length);
        for(int i:A) {
            System.out.print(i+" ");
        }
    }
}
