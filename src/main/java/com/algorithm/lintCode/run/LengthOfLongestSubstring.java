package com.algorithm.lintCode.run;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author wangkai43
 * @create 2017-08-26-22:32
 * @email wangkai43@meituan.com
 */
public class LengthOfLongestSubstring {
    /**
     * 样例
     例如，在"abcabcbb"中，其无重复字符的最长子字符串是"abc"，其长度为 3。

     对于，"bbbbb"，其无重复字符的最长子字符串为"b"，长度为1。

     挑战
     O(n) 时间

     空间超
    * @param : a string
    * @return: an integer
    */
    public int lengthOfLongestSubstringl(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        Map<Character,Integer> cMap = new HashMap<>(s.length());
        int max =0;
        int begin =0;
        int index ;
        for(index =0; index<s.length(); ){
            if(cMap.containsKey(s.charAt(index))){
                max = max>(index - begin)? max: (index - begin);
                begin = cMap.get(s.charAt(index)) +1;
                index = begin;
                cMap.clear();
            }else{
                cMap.put(s.charAt(index), index);
                index++;
            }
        }
        return max>(index - begin)? max: (index - begin);
    }

    /**
     * 应当注意字母表的使用，利用字母表直接记录下标，好过于直接存储记录字符的下标
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int[] chars = new int[256];
        for(int i=0;i<chars.length;i++){
            chars[i] = -1;
        }
        int max =0;
        int begin =0;
        int index ;

        for(index =0; index<s.length(); ){
            if(chars[s.charAt(index)] != -1){
                max = max>(index - begin)? max: (index - begin);
                begin = chars[s.charAt(index)] +1;
                index = begin;
                reSetArr(chars, -1);
            }else{
                chars[s.charAt(index)] = index;
                index++;
            }
        }
        return max>(index - begin)? max: (index - begin);
    }
    private void reSetArr(int[] arr,int value){
        if( arr.length ==0){
            return;
        }
        for(int i =0; i<arr.length; i++){
            if(arr[i] != value){
                arr[i] = value;
            }
        }
    }
}
