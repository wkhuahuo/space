package com.work.practice.mianshi.didi;

import java.util.Scanner;

/**
 * @author wangkai43
 * @create 2017-08-26-15:48
 * @email wangkai43@meituan.com
 */
public class DiDiMain2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        String[] strs = line.split(" ");
        int[] nums = new int[strs.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.valueOf(strs[i]);
        }
        int num = findKthlarger(nums,in.nextInt());
        System.out.println(num);
    }

    public static int findKthlarger(int[] nums, int k) {
        if(nums == null || nums.length == 0 || nums.length < k) return -1;
        int num = quickSort(nums,0,nums.length-1, k);
        return num;
    }

    private static int quickSort(int[] nums, int begin, int end, int k) {
        int l = begin;
        int r = end;
        int key = nums[begin];
        while(l < r) {
            while(l < r && nums[r] <= key) {
                r --;
            }
            if(l < r){
                nums[l ++] = nums[r];
            }

            while(l < r && nums[l] >= key) {
                l ++;
            }
            if(l < r){
                nums[r --] = nums[l];
            }
        }

        nums[l] = key;

        if(l == k - 1) {
            return nums[l];
        } else if(l < k - 1) {
            return quickSort(nums, l + 1, end, k);
        } else {
            return quickSort(nums, begin, l - 1, k);
        }
    }

}
