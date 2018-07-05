package com.algorithm.leetcode.contest;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wangkai43
 * @create 2017-10-15-12:46
 * @email wangkai43@meituan.com
 */
public class Longest_SubStr {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length()==0){
            return 0;
        }
        int i= 0, j= 0, max= 0;
        Set<Character> history = new HashSet<Character>();
        while(j<s.length()){
            if( !history.contains(s.charAt(j))){
                history.add(s.charAt(j++));
                max = max>history.size()? max: history.size();
            }else {
                history.remove(s.charAt(i++));
            }
        }
        return max;
    }
}
