package com.algorithm.batAlgorithm.string;

/**
 * Created by wkhua on 16/12/13.
 */
public class Translation {
    public String stringTranslation(String A, int n, int len) {
        char[] chars = A.toCharArray();
        reverse(chars,0,len-1);
        reverse(chars,len,n-1);
        reverse(chars,0,n-1);

        return new String(chars);

    }

    private void reverse(char[] sentence,int atBegin,int atEnd){
        char tmp;
        while(atBegin <atEnd){
            tmp = sentence[atBegin];
            sentence[atBegin] = sentence[atEnd];
            sentence[atEnd] = tmp;
            atBegin++;
            atEnd--;
        }

    }
}
