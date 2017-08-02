package com.algorithm.batAlgorithm.stackAndSequence.practice;

import java.util.Stack;

/**
 * Created by wkhua on 16/12/15.
 */
public class MaxTree {
    public int[] buildMaxTree(int[] A, int n) {
        int[] result =new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<n;i++){
            if(stack.isEmpty() || (A[i]<A[stack.peek()])){
                while(stack.isEmpty() || (A[i]<A[stack.peek()])){
                    if(stack.isEmpty()){
                        result[i] = -1;
                    }else{
                        result[i] =stack.peek();
                    }
                    stack.push(i);
                    break;
                }
            }else{
                while(!stack.isEmpty() && (A[i]>A[stack.peek()])){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    result[i] = -1;
                    stack.push(i);
                }else{
                    result[i] = stack.peek();
                    stack.push(i);
                }
            }
        }
        stack.clear();
        for(int i=n-1;i>=0;i--){
            if(stack.isEmpty() || (A[i]<A[stack.peek()])){
                while(stack.isEmpty() || (A[i]<A[stack.peek()])){
                    if(stack.isEmpty()){
                        if(result[i] == -1) {
                            result[i] = -1;
                        }
                    }else{
                        if(result[i]==-1 || (A[stack.peek()]<A[result[i]])) {
                            result[i] = stack.peek();
                        }
                    }
                    stack.push(i);
                    break;
                }
            }else{
                while(!stack.isEmpty() && (A[i]>A[stack.peek()])){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    if(result[i] == -1) {
                        result[i] = -1;
                    }
                    stack.push(i);

                }else{
                    if(result[i]==-1 || (A[stack.peek()]<A[result[i]])) {
                        result[i] = stack.peek();
                        stack.push(i);
                    }
                }
            }
        }

        return result;
    }

    public int[] buildMaxTreeDemo(int[] A, int n) {
        int[] res = new int[n];
        for(int i=0; i<n; i++){
            res[i] = -1;
        }
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=0; i<n; i++){
            while(!stack.empty() && A[stack.peek()]<A[i]){
                if(res[stack.peek()] == -1 || A[res[stack.peek()]] > A[i]){
                    res[stack.peek()] = i;
                }
                stack.pop();
            }
            if(!stack.empty()){
                res[i] = stack.peek();
            }
            stack.push(i);
        }
        return res;
    }

}
