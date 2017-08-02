package com.wk.batAlgorithm.string;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by wkhua on 16/12/7.
 */
public class RotationTest {
    @Test
    public void chkRotation(){
        String targetStr = "cbadaabcacbdabcaacbb";
        String patternStr = "abcaacbbcbadaabcacbd";
        Rotation r = new Rotation();
        boolean a = r.chkRotation(targetStr,targetStr.length(),patternStr,patternStr.length());
        Assert.assertTrue(a);

    }
}
