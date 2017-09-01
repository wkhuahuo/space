package com.algorithm.lintCode.run;

import java.util.List;

/**
 * @author wangkai43
 * @create 2017-08-31-18:01
 * @email wangkai43@meituan.com
 */
public class FindMajor {
    public int majorityNumber(List<Integer> nums) {
        // write your code here

        int history = nums.get(0);
        int count =0 ;
        for(Integer i : nums){

            if(count == 0){
                history = i;
            }

            if(history == i){
                count++;
            }else{
                count--;
            }
        }
        return  history;
    }
}
