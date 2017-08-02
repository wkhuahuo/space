package com.algorithm.swordoffer.test.chapter5;

import com.algorithm.swordoffer.run.Chapter5.FirstOnce_35;

/**
 * Created by wkhuahuo on 2017/3/26.
 */
public class FirstOnce_35Test {
    public static void main(String[] args){
        FirstOnce_35 first = new FirstOnce_35();
        String str = "NXWtnzyoHoBhUJaPauJaAitLWNMlkKwDYbbigdMMaYfkVPhGZcrEwp";
        int d =first.FirstNotRepeatingChar(str);
        System.out.println(d);
    }
}
