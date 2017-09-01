package com.algorithm.lintCode.run;

/**
 * @author wangkai43
 * @create 2017-09-01-11:18
 * @email wangkai43@meituan.com
 */
public class PlusOne {
    /*
    * @param digits: a number represented as an array of digits
    * @return: the result
    */
    public int[] plusOne(int[] digits) {
        // write your code here
        if(digits == null || digits.length ==0){
            return digits;
        }
        int carry =0;
        for(int i=digits.length -1;i>=0;i--){
            int tmp =0;
            if(i == digits.length -1){
                tmp = (carry+digits[i]+1)/10;
                digits[i] = (carry+digits[i]+1)%10;
                carry = tmp;
            }else{
                tmp = (carry+digits[i])/10;
                digits[i] = (carry+digits[i])%10;
                carry = tmp;
            }

        }
        if(carry != 0){
            int[] newarr = new int[digits.length+1];
            newarr[0] = carry;
            for(int i=1; i< digits.length; i++){
                newarr[i] = digits[i-1];
            }
            return newarr;
        }else{
            return digits;
        }
    }
}
