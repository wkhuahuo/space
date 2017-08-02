package com.algorithm.lintCode.run;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangkai43 on 2017/7/25.
 */
public class SumofTwo {
    public int[] twoSum(int[] numbers, int target) {
        // write your code here
        Map<Integer,Integer> numMap = new HashMap<Integer,Integer>();
        int[] result = new int[2];
        for(int i = 0; i< numbers.length;i++){
            int tmpNum = target-numbers[i];
            if(numMap.containsKey(numbers[i])){
                result[0] =numMap.get(numbers[i])+1;
                result[1] = i+1;
            }else{
                numMap.put(tmpNum,i);
            }
        }

        return result;

    }
}
