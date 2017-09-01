package com.algorithm.lintCode.run;

/**
 * 实现atoi这个函数，将一个字符串转换为整数。
 * 如果没有合法的整数，返回0。
 * 如果整数超出了32位整数的范围，
 * 返回INT_MAX(2147483647)如果是正整数，
 * 或者INT_MIN(-2147483648)如果是负整数。
 *
 * @author wangkai43
 * @create 2017-08-31-17:20
 * @email wangkai43@meituan.com
 */
public class StringToNum {

    /**
     *
     * @param str: A string
     * @return: An integer
     */
    public int atoi(String str) {
        // write your code here
        if(str == null || str.length() == 0){
            return 0;
        }
        str = str.trim();
        int pos = 0;
        boolean isPositive = true;
        if(str.charAt(pos) == '+'){
            pos++;
        } else if(str.charAt(pos) == '-'){
            pos++;
            isPositive = false;
        }
        double result =0;
        while (pos<str.length() && str.charAt(pos) <= '9' && str.charAt(pos) >= '0'){
            result = result * 10 + str.charAt(pos) - '0';
            pos++;
        }
        if(!isPositive){
            result = -result;
        }
        if(result>Integer.MAX_VALUE){
            result = Integer.MAX_VALUE;
        }
        if(result<Integer.MIN_VALUE){
            result = Integer.MIN_VALUE;
        }

        return (int)result;
    }


}
