package com.algorithm.batAlgorithm.stackAndSequence.practice;

import java.util.Stack;

/**
 * Created by wkhua on 16/12/14.
 */
public class TwoStack {

    public int[] twoStack(int[] ope, int n) {
        int[] result = new int[ope.length];
        int count=0;
        int space =0;
        for(int i=0;i<ope.length;i++){

            if(ope[i] == 0){
                result[count++] =pop();
                space++;
            }else{
                push(ope[i]);
            }
        }

        int[] ints = new int[space];
        for(int i=0;i<ints.length;i++){
            ints[i] = result[i];
        }
        return ints;
    }
    Stack<Integer> first = new Stack<>();
    Stack<Integer> second = new Stack<>();

    public void push(int n){
        first.push(n);
    }
    public int pop(){
        int num = -1;
        if(second.isEmpty()) {
            while (!first.isEmpty()) {
                second.push(first.peek());
                first.pop();
            }
        }
        if(!second.isEmpty()){
            num = second.peek();
            second.pop();
        }
        return num;
    }


}
