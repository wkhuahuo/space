package com.algorithm.batAlgorithm.sort.practice;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by wkhua on 16/11/15.
 */
public class RepeatCheckerTest {
    /*
    * 请设计一个高效算法，判断数组中是否有重复值。必须保证额外空间复杂度为O(1)。
给定一个int数组A及它的大小n，请返回它是否有重复值。
测试样例：
[1,2,3,4,5,5,6],7
返回：true
    * */
    @Test
    public void testCheckDuplicate() {
        // write code here
        int[] a = {2,1,3,7,5,5,6};
        RepeatChecker rc = new RepeatChecker();
        boolean flg = rc.checkDuplicate(a,a.length);
        Assert.assertTrue(flg == true);
    }

}
