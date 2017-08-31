package com.algorithm.lintCode.run;

/**
 * @author wangkai43
 * @create 2017-08-31-14:45
 * @email wangkai43@meituan.com
 */
public class LongestPalindromicSubstring {
   /**
    * 使用Manacher方法
    * @param s: input string
    * @return: the longest palindromic substring
    */
    public String longestPalindrome(String s) {
        // write your code here
        char[] arr = preProcess(s);//预处理字符串。
        int[] P = new int[s.length()];//存储最大回文串的长度。初始大小为零。
        int maxR = 0;//存储当前最长回文串的最右位置；
        int pos = 0;//存储当前最大回文串的中心位置;

        for(int i=1 ; i< arr.length; i++){
            //比较i相对于pos的对称位置j的P[j]与 maxR-i的大小，取最小值
            int min = P[2*pos -i] > (maxR -i) ? (maxR -i): P[2*pos -i];
            P[i] =  (maxR>i ? min : 1);//判断当前求解位置与maxR所在位置，如果i在maxR的右边，则初始P[i] = 1 ,否则取值为min;
            while (arr[i+P[i]] == arr[i-P[i]]) P[i]++;//以当前位置向两边继续判断
            if(i+P[i] > maxR){//可能当前位置的右边位置大于原有的maxR。如果是，更新maxR与对称点
                maxR = i+P[i];
                pos = i;
            }
        }
        int mid =0;
        int maxLength = 0;
        for(int i=0;i<P.length;i++){
            if(maxLength < P[i]){
                maxLength =P[i];
                mid = i;
            }
        }

        return afterProcess(arr, mid,maxLength);
    }

    private char[] preProcess(String s){
        StringBuffer strb = new StringBuffer();
        strb.append('$');
        strb.append('#');
        for(int i=0;i < s.length(); i++){
            strb.append(s.charAt(i));
            strb.append('#');
        }
        return strb.toString().toCharArray();
    }

    private String afterProcess(char[] chars, int mid, int len){
        String s = new String(chars);
        StringBuffer strb = new StringBuffer();
        String subs = s.substring(mid-len, mid+len+1);
        for(int i=0;i<subs.length();i++){
            if(subs.charAt(i)!='#' && subs.charAt(i)!='$'){
                strb.append(subs.charAt(i));
            }
        }
        return strb.toString();
    }
}
