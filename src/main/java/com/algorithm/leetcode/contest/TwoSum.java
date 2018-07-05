package com.algorithm.leetcode.contest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wangkai43
 * @create 2017-10-14-18:30
 * @email wangkai43@meituan.com
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length ==0){
            return nums;
        }
        int[] result = new int[2];
        Map<Integer,Integer> contains = new HashMap<Integer,Integer>();
        for(int i=0;i< nums.length;i++){
            if(!contains.containsKey(nums[i])) {
                contains.put(target-nums[i],i);
            }else{
                result[0] = contains.get(nums[i]);
                result[1] = i;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TwoSum t = new TwoSum();
        int[] nums = {3,2,4};
        int target = 6;
        int[] res = t.twoSum(nums,target);
        System.out.println(Arrays.toString(res));
    }
}
