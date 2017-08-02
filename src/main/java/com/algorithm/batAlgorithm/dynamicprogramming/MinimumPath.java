package com.algorithm.batAlgorithm.dynamicprogramming;



/**
 * Created by wkhuahuo on 2017/2/28.
 */
public class MinimumPath {

    public int getMin(int[][] map, int n, int m) {
        if(map == null || n<=0||m<=0){
            return 0;
        }
        int[][] result = new int[n][m];
        int tmp =0;
        for(int i=0;i<n;i++){
            result[i][0] =map[i][0]+tmp;
            tmp = result[i][0];
        }
        tmp =0;
        for (int j=0;j<m;j++){
            result[0][j] = map[0][j]+tmp;
            tmp = result[0][j];
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                result[i][j] = map[i][j] +(result[i-1][j]>result[i][j-1] ? result[i][j-1]: result[i-1][j]);
            }
        }

        return result[n-1][m-1];

    }
}

