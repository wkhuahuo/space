package com.wk.batAlgorithm.sort.practice;


import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by wkhua on 16/12/1.
 */
public class ArrayFindTest {

    @Test
    public void testFindX(){
        int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
        ArrayFind af = new ArrayFind();
        boolean a = af.findX(mat,mat.length,mat[mat.length-1].length,10);
        Assert.assertFalse(a);
    }
}
