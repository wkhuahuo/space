package com.algorithm.batAlgorithm.string;

/**
 * Created by wkhua on 16/12/13.
 */
public class Reverse {
    public String reverseSentence(String A, int n) {
        char[] sentenceChar = A.toCharArray();
        int begin =0;
        int end = 0;
        for(int i=0;i<n;i++){

            if(' '==sentenceChar[i] && i>0){
                end = i-1;
                reverse(sentenceChar,begin,end);
                begin = i+1;

            }
            if(i==n-1 && ' '!=sentenceChar[i]){
                end = n-1;
                reverse(sentenceChar,begin,end);

            }
        }
        reverse(sentenceChar,0,n-1);

        return new String(sentenceChar);
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
