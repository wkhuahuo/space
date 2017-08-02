package com.algorithm.batAlgorithm.dynamicprogramming;

import org.junit.Test;

/**
 * Created by wkhuahuo on 2017/2/28.
 */
public class LCSTest {
    @Test
    public void findLCS(){
        LCS lcs = new LCS();
        String A ="B1D23CA45B6A";
        String B ="1A2C3D4B56";

//      String A ="ttrmeoqrheqojqaxiobgmvmievtbbi";
//      String B ="cxgzqczkjxjfyyzuhtgxrgfqojoogcxgluqzveuznczntawtbfov";

        int m =lcs.findLCS(A,A.length(),B,B.length());
        System.out.println(m);
    }
}
