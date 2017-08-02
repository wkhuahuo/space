package com.algorithm.swordoffer.run.Chapter5;

/**
 * Created by wkhuahuo on 2017/3/26.
 */
public class FirstOnce_35 {
    public int FirstNotRepeatingChar(String str) {
        int[] chars = new int[255];

        for(int i=0;i<str.length();i++){
            chars[str.charAt(i)] ++;
        }
        for(int i=0; i<str.length(); i++){
            if(chars[str.charAt(i)] == 1){

               return i;
            }
        }

        return -1;
    }
}
