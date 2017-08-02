package com.algorithm.batAlgorithm.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wkhua on 16/12/14.
 */
public class DistinctSubstring {
    public int longestSubstring(String A, int n) {
        char[] charsA = A.toCharArray();
        int pre = -1;
        int maxlen = 0;
        Map<Character,Integer> charPos = new HashMap<>();
        for(int i=0;i<charsA.length;i++){
            if(charPos.containsKey(charsA[i])){
                if(charPos.get(charsA[i])>pre) {
                    pre = charPos.get(charsA[i]);
                }
                charPos.put(charsA[i],i);//更新字符位置

            }else{
                charPos.put(charsA[i],i);//放置字符
            }
            if(i-pre>maxlen ) {
                maxlen = i - pre;
            }

        }
        return maxlen;
    }
}
