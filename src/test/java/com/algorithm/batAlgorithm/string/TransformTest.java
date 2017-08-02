package com.algorithm.batAlgorithm.string;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by wkhua on 16/12/7.
 */
public class TransformTest {

    @Test
    public void chkTransform(){
        String A = "abcac";
        String B = "bcaca";
        Transform transform = new Transform();
        boolean b = transform.chkTransform(A,A.length(),B,B.length());
        Assert.assertTrue(b);
    }

    @Test
    public void chkTransformOfArr(){
        String A = "abcac";
        String B = "bcaca";
        Transform transform = new Transform();
        boolean b= transform.chkTransformOfArr(A,A.length(),B,B.length());
        Assert.assertTrue(b);
    }
}
