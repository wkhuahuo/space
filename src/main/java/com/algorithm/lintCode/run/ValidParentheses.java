package com.algorithm.lintCode.run;


import java.util.Stack;

/**
 * @author wangkai43
 * @create 2017-09-01-10:29
 * @email wangkai43@meituan.com
 */
public class ValidParentheses {
    /*
     * @param s: A string
     * @return: whether the string is a valid parentheses
     */
    public boolean isValidParentheses(String s) {
        // write your code here
        char[] chars = s.toCharArray();
        Stack stack = new Stack();
        char[] left = {'(','[','{'};
        char[] right = {')',']','}'};

        for(int i=0; i< chars.length; i++){
            int index = 0;
            if(chars[i] == left[index++] || chars[i] == left[index++] || chars[i] == left[index++]){
                stack.push(index-1);
            }
            index =0;
            if(chars[i] == right[index++] || chars[i] == right[index++] || chars[i] == right[index++]){
                if( stack.isEmpty() || (Integer)stack.peek() != index-1) {
                    return false;
                }else {
                    stack.pop();
                }
            }
        }
        if( !stack.isEmpty()){
            return false;
        }
        return true;
    }
}
