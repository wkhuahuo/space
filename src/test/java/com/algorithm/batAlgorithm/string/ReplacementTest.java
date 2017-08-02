package com.wk.batAlgorithm.string;

import org.junit.Test;

/**
 * Created by wkhua on 16/12/13.
 */
public class ReplacementTest {
    @Test
    public void replaceSpaceTest(){
        //String str ="Mr Jo  hn Smith";
        String str ="qw";
        Replacement replacement = new Replacement();
        String replacedStr = replacement.replaceSpace(str,str.length());
        System.out.println(replacedStr);
    }
}
