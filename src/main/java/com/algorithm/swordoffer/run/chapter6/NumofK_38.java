package com.algorithm.swordoffer.run.chapter6;

/**
 * 时间限制：1秒 空间限制：32768K 热度指数：7717
 本题知识点： 数组
 算法知识视频讲解
 题目描述
 统计一个数字在排序数组中出现的次数。
 * Created by wkhuahuo on 2017/3/27.
 */
public class NumofK_38 {
    public int GetNumberOfK(int [] array , int k) {
        if(array == null || array.length==0){
            return 0;
        }
        return searchKs(array, 0, array.length-1, k);
    }

    private int searchKs(int[] array, int left, int right,int k){

        int leftindex = -1;
        int rightindex = -1;
        int mid =0;
        int leftV = left;
        int rightV = right;
        while(left <= right) {
            mid = left+(right-left)/2;
            if (array[mid] == k) {
                int tmpm = left + (mid - left) / 2;
                if(array[left] != k) {
                    while (array[tmpm] <= k && left <= mid) {
                        if (array[tmpm] < k) {
                            left = tmpm + 1;
                        } else {
                            mid = tmpm - 1;
                        }
                        tmpm = left + (mid - left) / 2;
                    }
                    leftindex = tmpm;
                }else{
                    leftindex =left;
                }

                tmpm = mid+(right - mid)/2;
                if(array[right] != k) {
                    while (array[tmpm] >= k && right >= mid) {

                        if (array[tmpm] > k) {
                            right = tmpm - 1;
                        } else {
                            mid = tmpm + 1;
                        }
                        tmpm = mid + (right - mid) / 2;
                    }
                    rightindex = tmpm;
                }else {
                    rightindex = right+1;
                }
                break;
            } else if (array[mid] > k) {
                right = mid-1;
            } else if(array[mid] < k){
                left = mid+1;
            }
        }
        return rightindex - leftindex;
    }


}
