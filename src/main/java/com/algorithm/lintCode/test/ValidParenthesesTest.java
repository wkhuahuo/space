package com.algorithm.lintCode.test;

import com.algorithm.lintCode.run.ValidParentheses;

/**
 * @author wangkai43
 * @create 2017-09-01-10:56
 * @email wangkai43@meituan.com
 */
public class ValidParenthesesTest {
    public static void main(String[] args) {
        ValidParentheses va = new ValidParentheses();
        String s= "()";
        boolean bool = va.isValidParentheses(s);
        System.out.println(bool);
    }
}
