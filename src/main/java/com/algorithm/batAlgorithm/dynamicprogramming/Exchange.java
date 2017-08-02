package com.algorithm.batAlgorithm.dynamicprogramming;

/**
 * 链接：https://www.nowcoder.com/courses/1/12/2
 来源：牛客网

 有数组penny，penny中所有的值都为正数且不重复。每个值代表一种面值的货币，每种面值的货币可以使用任意张，再给定一个整数aim(小于等于1000)代表要找的钱数，求换钱有多少种方法。
 给定数组penny及它的大小(小于等于50)，同时给定一个整数aim，请返回有多少种方法可以凑成aim。
 测试样例：
 [1,2,4],3,3
 返回：2
 * Created by wkhuahuo on 2017/2/26.
 */
public class Exchange {
    public int countWays(int[] penny, int n, int aim) {

        return coins(penny,n,aim);
    }
    public int coins(int[] penny, int n,int aim){
        if(penny ==null || aim<0 || penny.length == 0 ){
            return 0;
        }
        int[][] map = new int[penny.length][aim+1];
        return process(penny, 0, aim ,map);
    }
    private int process(int[] penny,int n,int aim,int[][] map){

        for(int i=0;i<penny.length;i++){
            map[i][0] = 1;
        }
        for(int j=0;j<=aim;j++){
            map[0][j] = j%penny[0] == 0?1:0;
        }
        for(int i=1;i<penny.length;i++){
            for(int j=1;j<=aim;j++){
                if(j-penny[i]<0){
                    map[i][j] = map[i-1][j];
                }else {
                    map[i][j] = map[i - 1][j] + map[i][j - penny[i]];
                }
            }
        }

        return map[penny.length-1][aim];
    }




    public int coins1(int[] penny,int n,int aim){
        if(penny ==null || aim<0 || penny.length == 0 ){
            return 0;
        }
        return coinsProcess(penny, 0, aim);
    }
    private int coinsProcess(int[] penny,int n,int aim){
        int res = 0;
        if(penny.length == n){
            res =aim == 0 ? 1:0;
        }else {
            for (int i = 0; penny[n]*i <= aim; i++ ) {
                res += coinsProcess(penny,n+1,aim-penny[n]*i);
            }
        }
        return res;
    }

    public int coins2(int[] penny, int n, int aim){
        if(penny ==null || aim<0 || penny.length == 0 ){
            return 0;
        }
        int[][] map = new int[penny.length][aim+1];
        return coinsProcess(penny, 0, aim , map);
    }
    private int coinsProcess(int[] penny,int n,int aim,int[][] map){
        int res = 0;
        if(penny.length == n){
            res =aim == 0 ? 1:0;
        }else {
            int mapValue =0;
            for (int i = 0; penny[n]*i <= aim; i++ ) {
                mapValue = map[n][aim-penny[n]*i] ;
                if(mapValue !=0){
                    res +=mapValue;
                }else {
                    res += coinsProcess(penny, n + 1, aim - penny[n] * i);
                }
            }
        }
        return res;
    }
}
