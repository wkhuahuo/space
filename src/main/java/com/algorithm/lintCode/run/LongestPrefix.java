package com.algorithm.lintCode.run;

/**
 * @author wangkai43
 * @create 2017-09-01-17:30
 * @email wangkai43@meituan.com
 */
public class LongestPrefix {
    /*
     * @param strs: A list of strings
     * @return: The longest common prefix
     */
    public String longestCommonPrefix(String[] strs) {
        // write your code here
        if(strs== null || strs.length!=0){
            return null;
        }
        char nowchar  = strs[0].charAt(0);

        int position=0;

        for(int i=0;i<strs.length;i++){
            if(nowchar != strs[i].charAt(position)){
                break;
            }
            position++;
            if(position>=strs[0].length()) {
                break;
            }
            nowchar = strs[0].charAt(position);
        }
        return strs[0].substring(0, position);
    }
}
