package com.algorithm.swordoffer.run.Chapter7;

/**
 * 时间限制：1秒 空间限制：32768K 热度指数：3790
 本题知识点： 字符串
 算法知识视频讲解
 题目描述
 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 * Created by wkhuahuo on 2017/3/28.
 */
public class RegularEx {
    public boolean match(char[] str, char[] pattern){
        if(str == null || pattern == null){
            return false;
        }
        int strBegin =0;
        int patternBegin =0;
        return matchCore(str, strBegin,pattern,patternBegin);

    }
    private boolean matchCore(char[]str,int strBegin,char[] pattern,int patternBegin){
        //有效性检验
        //都达到了末尾返回true
        if(strBegin == str.length && patternBegin == pattern.length){
            return true;
        }
        //如果str没有到末尾，pattern到了末尾则返回false
        if(strBegin != str.length && patternBegin == pattern.length){
            return false;
        }


        if(patternBegin+1<pattern.length && pattern[patternBegin+1] == '*'){//如果下一个是*那么进行配。
            if((strBegin != str.length && pattern[patternBegin] == str[strBegin])
                    ||(strBegin != str.length && pattern[patternBegin] == '.' )){

                return matchCore(str,strBegin, pattern, patternBegin+2)//匹配零个字符
                        || matchCore(str, strBegin+1,pattern,patternBegin+2)//匹配一个字符
                        || matchCore(str, strBegin+1,pattern,patternBegin);//匹配一个字符，接着匹配另一个

            }else{//没有成功匹配则忽略当前的*
                return matchCore(str,strBegin,pattern,patternBegin+2);
            }
        }
        //如果下一个字符不是* 那么当第一个字符都相等时进行下一个匹配，否则返回false
        if((strBegin < str.length && str[strBegin] == pattern[patternBegin])
                || (strBegin < str.length && pattern[patternBegin] == '.')){
            return matchCore(str,strBegin+1,pattern,patternBegin+1);
        }

        return false;
    }
}
