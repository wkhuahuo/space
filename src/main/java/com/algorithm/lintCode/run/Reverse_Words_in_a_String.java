package com.algorithm.lintCode.run;

/**
 * Created by wangkai43 on 2017/7/27.
 */
public class Reverse_Words_in_a_String {

    /**
     * @param s : A string
     * @return : A string
     */
    public String reverseWords(String s) {
        // write your code
        int begin = 0;
        int end = 0;
        char[] words =s.toCharArray();
        int len = s.length();

        for(int i=0;i<len ;i++){
            end =i;
            if(' ' == words[end]){
                reverseWord(words,begin,end-1);
                begin = end+1;
            }else if(end == (len-1) ){
                reverseWord(words,begin,end);
                begin = end+1;
            }
        }
        reverseWord(words,0,len-1);
        int index = 0;
        int pre = 0;

        for(int i=0;i<len;){
            if(words[i]!=' '){

                words[index] = words[pre];
                if(index != pre){
                    words[pre] =' ';
                }
                index++;
                pre++;
                i++;
            }else{
                if(index != 0){
                    pre++;
                    index++;
                    i++;
                }

                while(pre<len && words[pre] ==' '){
                    pre++;
                    i++;
                }
            }

        }


        return new String(words,0,index);
    }

    private void reverseWord(char[] words, int begin, int end){
        if(begin>=end){
            return;
        }
        char tmpChar;
        int len = end - begin +1;
        for(int i=begin; i<begin+len/2; i++){
            tmpChar = words[i];
            words[i] = words[end-(i-begin)];
            words[end-i+begin] = tmpChar;
        }
        return;
    }
}
