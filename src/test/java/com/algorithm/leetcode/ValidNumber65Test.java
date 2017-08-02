package com.wk.leetcode;

import org.junit.Test;

/**
 * Created by wkhuahuo on 2017/3/15.
 */
public class ValidNumber65Test {

    @Test
    public void isNumber(){
        ValidNumber65 vali = new ValidNumber65();
     //   String str = "e123";
        String str = "-1";
        boolean f = vali.isNumber(str);
        System.out.println(f);
    }
}
