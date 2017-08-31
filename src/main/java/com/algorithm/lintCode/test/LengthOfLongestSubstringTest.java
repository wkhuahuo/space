package com.algorithm.lintCode.test;

import com.algorithm.lintCode.run.LengthOfLongestSubstring;
import org.junit.Test;

/**
 * @author wangkai43
 * @create 2017-08-26-22:40
 * @email wangkai43@meituan.com
 */
public class LengthOfLongestSubstringTest {

    private LengthOfLongestSubstring length = new LengthOfLongestSubstring();

    @Test
    public void testLengthOfLengestSubString(){
        String s = "abcab";
        long beging = System.currentTimeMillis();
        int maxL = length.lengthOfLongestSubstring(s);
        long end = System.currentTimeMillis();
        System.out.println(maxL);
        System.out.println(end - beging);
    }
}
