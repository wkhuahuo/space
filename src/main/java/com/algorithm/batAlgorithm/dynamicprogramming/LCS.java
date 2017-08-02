package com.algorithm.batAlgorithm.dynamicprogramming;

/**
 * Created by wkhuahuo on 2017/2/28.
 */
public class LCS {
    public int findLCS(String A, int n, String B, int m) {
        int[][] map = new int[n][m];
        int tmp1 = 0;
        int tmp2 =0;
        for(int i=0;i<n;i++){
            if(A.charAt(i) == B.charAt(0)){
                tmp1 =1;
            }
            map[i][0] = tmp1;
        }
        for(int i=0;i<m;i++){
            if(B.charAt(i) == A.charAt(0)){
              tmp2 =1;
            }
            map[0][i] = tmp2;
        }
        for(int Ad=1;Ad<n ;Ad++) {
            for(int Br=1;Br<m;Br++){

                if (A.charAt(Ad) == B.charAt(Br)) {
                    map[Ad][Br] = map[Ad-1][Br-1]+1;
                }else{
                    map[Ad][Br] = Math.max(map[Ad - 1][Br], map[Ad][Br - 1]);
                }
            }
        }
        return map[n-1][m-1];
    }
}
