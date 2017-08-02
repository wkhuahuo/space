package com.algorithm.swordoffer.run.chapter6;

/**
 * Created by wkhuahuo on 2017/3/26.
 */
public class ReverseStr_42 {
    public String ReverseSentence(String str) {
        if(str == null || str.length()<2 ){
            return str;
        }
        char[] chars = str.toCharArray();
        reversWords(chars,0,chars.length-1);
        int left = 0 ,right = 0;
        while (right<chars.length){//right++寻找空格
            if(chars[right] == ' '){
                if(right-left >0) {//找到之后判断right和left的间距是否大于1
                    reversWords(chars, left, right - 1);
                }
                left = right+1;//左字符设置为每次空格之后的那个字符位置，有可能溢出。
            }
            right++;//right自增。如果当时left已经溢出，那么right也会发生溢出
        }
        reversWords(chars, left, right-1);//可能结尾没有空格此时right应为length-1;反转最后一个空格到结尾的串

        return new String().valueOf(chars);
    }
    private void reversWords(char[] chars,int l,int r){
        char tmp =0;
        while (l<r) {
            tmp = chars[l];
            chars[l] =  chars[r];
            chars[r] = tmp;
            l++;
            r--;
        }

        return ;
    }
}
