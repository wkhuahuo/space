package com.work.practice.mianshi.didi;

import java.util.Scanner;

/**
 * @author wangkai43
 * @create 2017-08-26-15:47
 * @email wangkai43@meituan.com
 */
public class DiDiMain1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String line = in.nextLine();
        String[] strs = line.split(" ");
        int[] nums = new int[strs.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.valueOf(strs[i]);
        }
        int max = maxSubArray(nums);
        System.out.println(max);

    }

    public static int maxSubArray(int[] intArrs) {
            if(intArrs == null || intArrs.length == 0){
                return 0;
            }
            int result = 0;
            int tmpSum = 0;
            int max = Integer.MIN_VALUE;

            for(int i = 0; i < intArrs.length; i++) {
                tmpSum += intArrs[i];
                max = intArrs[i] < 0 && intArrs[i] > max ? intArrs[i] : max;
                tmpSum = tmpSum < 0 ? 0 : tmpSum;
                result = tmpSum > result ? tmpSum : result;
            }
            return result == 0 ? max : result;
        }


}
