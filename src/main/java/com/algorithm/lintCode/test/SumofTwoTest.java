package com.algorithm.lintCode.test;

import com.algorithm.lintCode.run.SumofTwo;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by wangkai43 on 2017/7/25.
 */
public class SumofTwoTest {
    @Test
    public void twoSum(){
        int[] nums = {2,7,11,15};
        int target = 9;
        SumofTwo sumofTwo = new SumofTwo();
        int[] result = sumofTwo.twoSum(nums,target);
        System.out.println(Arrays.toString(result));

    }
}
