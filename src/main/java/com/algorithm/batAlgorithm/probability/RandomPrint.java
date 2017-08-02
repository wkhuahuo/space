package com.algorithm.batAlgorithm.probability;

import java.util.Random;

/**
 * 给定一个长度为N且没有重复元素的数组arr和一个整数M，实现函数等概率随机打印arr中的M个数。
 * Created by wkhuahuo on 20/02/17.
 */
public class RandomPrint {
    public int[] print(int[] arr, int N, int M) {

        int[] m = new int[M];
        int index = 0;
        while(M>index){
            int i = random(N-index);
            m[index] = arr[i];
            arr[i] = arr[N-index-1];
            arr[N-index-1] = m[index];

            index++;
        }

        return m;
    }
    private int random(int end){
        Random rand = new Random();
        return rand.nextInt(end);
    }
}
