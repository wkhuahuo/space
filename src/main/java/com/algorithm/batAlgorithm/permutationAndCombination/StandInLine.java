package com.algorithm.batAlgorithm.permutationAndCombination;

/**
 *
 n个人站队，他们的编号依次从1到n，要求编号为a的人必须在编号为b的人的左边，但不要求一定相邻，请问共有多少种排法？第二问如果要求a必须在b的左边，并且一定要相邻，请问一共有多少种排法？
 给定人数n及两个人的编号a和b，请返回一个两个元素的数组，其中两个元素依次为两个问题的答案。保证人数小于等于10。
 测试样例：
 7,1,2
 返回：[2520,720]
 * Created by wkhuahuo on 18/02/17.
 */
public class StandInLine {
    public int[] getWays(int n, int a, int b) {
        int[] arr = new int[2];
        int tmp=1;
        for(int i=n;i>0;i-- ){
            tmp =tmp*i;
        }
        arr[0] = tmp/2;
        tmp = 1;
        for(int i=n-1;i>0;i--){
            tmp = tmp*i;
        }
        arr[1] = tmp;
        return arr;
    }

}
