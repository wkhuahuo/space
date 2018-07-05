package com.work.practice.mianshi.wangyi;

import java.util.Scanner;

/**
 * @author wangkai43
 * @create 2017-09-09-14:50
 * @email wangkai43@meituan.com
 */
public class XiaoZhao1 {


        public static void main(String[] args) {

            Scanner in = new Scanner(System.in);
            int lines = in.nextInt();
            String[] result = new String[lines];

            for(int i = 0;i < lines;i++){
                in.nextLine();
                int num = in.nextInt();
                in.nextLine();

                int[] nums = new int[num];
                for(int j = 0;j < num ;j++) {
                    nums[j] = in.nextInt();
                }
                result[i] = isFours(nums)?  "Yes": "No";
            }

            for(int i = 0;i < result.length;++i){
                System.out.println(result[i]);
            }
        }
        public static boolean isFours(int[] nums) {
            int tow = 0;
            int four = 0;
            int enh = 0;
            for(int i = 0;i < nums.length; i++) {
                if(nums[i] % 2 == 1) {
                    tow++;
                }else {
                    enh++;
                    if(nums[i] % 4 == 0) {
                        ++four;
                    }
                }
            }
            if(nums.length == 1) {
                return true;
            }
            if(tow > (nums.length + 1) / 2) {
                return false;
            }else if(tow == (nums.length + 1) / 2) {
                return (tow + four == nums.length)?  true : false;
            }else {
                return (tow <= four)?  true : false;
            }
        }


}
